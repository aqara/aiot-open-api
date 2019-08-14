package com.lumi.opencloud.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.*;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Http Utils
 * @author lumi
 */
public class PooledHttpClientUtils {
    private static Logger log = LoggerFactory.getLogger(PooledHttpClientUtils.class);

    private static final String CONTENT_JSON = "application/json; charset=utf-8";
    private static final String CONTENT_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded; charset=utf-8";

    private static final int DEFAULT_POOL_MAX_TOTAL = 500;
    private static final int DEFAULT_POOL_MAX_PER_ROUTE = 500;

    private static final int DEFAULT_CONNECT_TIMEOUT = 1500;
    private static final int DEFAULT_CONNECT_REQUEST_TIMEOUT = 1500;
    private static final int DEFAULT_SOCKET_TIMEOUT = 5000;

    private static volatile CloseableHttpClient httpClient = null;
    private static IdleConnectionMonitorThread idleThread = null;


    private static CloseableHttpClient createHttpClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().build();
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs,
                                               String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs,
                                               String authType) {
                }
            }}, null);

            SSLConnectionSocketFactory sslsfl= new SSLConnectionSocketFactory(sslContext,
                    new String[] { "TLSv1" }, null,SSLConnectionSocketFactory.getDefaultHostnameVerifier());


            ConnectionSocketFactory socketFactory = PlainConnectionSocketFactory.getSocketFactory();
            Registry<ConnectionSocketFactory> registry = RegistryBuilder
                    .<ConnectionSocketFactory>create()
                    .register("http", socketFactory)
                    .register("https", new SSLConnectionSocketFactory(sslContext))
                    .build();

            //创建连接管理器
            PoolingHttpClientConnectionManager pcm = new PoolingHttpClientConnectionManager(registry);
            // Create socket configuration
            SocketConfig socketConfig = SocketConfig.custom()
                    .setTcpNoDelay(true).build();
            pcm.setDefaultSocketConfig(socketConfig);
            // Create message constraints
            MessageConstraints messageConstraints = MessageConstraints.custom()
                    .setMaxHeaderCount(200).setMaxLineLength(2000).build();
            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setMalformedInputAction(CodingErrorAction.IGNORE)
                    .setUnmappableInputAction(CodingErrorAction.IGNORE)
                    .setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints).build();
            pcm.setDefaultConnectionConfig(connectionConfig);
            pcm.setMaxTotal(DEFAULT_POOL_MAX_TOTAL);
            pcm.setDefaultMaxPerRoute(DEFAULT_POOL_MAX_PER_ROUTE);

            //重试处理
            HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
                @Override
                public boolean retryRequest(IOException e, int count, HttpContext httpContext) {
                    if (count >= 3) {
                        return false;
                    }
                    if (e instanceof NoHttpResponseException){
                        //连接丢失，尝试重连
                        return true;
                    }
                    if (e instanceof InterruptedIOException){
                        return false;
                    }
                    if (e instanceof UnknownHostException){
                        return false;
                    }

                    HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
                    HttpRequest httpRequest = clientContext.getRequest();
                    //请求幂等，重试
                    if (!(httpRequest instanceof HttpEntityEnclosingRequest)){
                        return true;
                    }
                    return false;
                }
            };


            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(DEFAULT_CONNECT_REQUEST_TIMEOUT)
                    .setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
                    .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
                    .build();

            return HttpClients.custom()
                    .setConnectionManager(pcm)
                    .setRetryHandler(httpRequestRetryHandler)
                    .setDefaultRequestConfig(requestConfig)
                    .setSSLSocketFactory(sslsfl)
                    .build();

        } catch (NoSuchAlgorithmException e) {
            log.error("SslContext builder init. NoSuchAlgorithmException", e);
        } catch (KeyManagementException e) {
            log.error("SslContext builder init. KeyManagementException.", e);
        }
        return null;
    }

    /**
     * 获取httpclient对象
     *
     * @return httpclient对象
     */
    public static CloseableHttpClient getHttpClient() {

        if (httpClient == null) {
            // 双重校验
            synchronized (PooledHttpClientUtils.class) {
                if (httpClient == null) {
                    httpClient = createHttpClient();
                }
            }
        }

        return httpClient;
    }

    public static String doGet(String url, Map<String, String> headers){
        return doGet(url, headers, null);
    }

    public static String doGet(String url, Map<String, String> headers, Map<String, Object> params) {

        httpClient = getHttpClient();
        /**
         * 构建GET请求头
         */
        HttpGet httpGet = null;
        if(null != params && !params.isEmpty()){
            String apiUrl = getUrlWithParams(url, params);
            httpGet = new HttpGet(apiUrl);
        }else{
            httpGet = new HttpGet(url);
        }

        /**
         * 设置header信息
         */
        if ( headers != null && headers.size() > 0 ) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            return getResponseResult(response);
        } catch (IOException e) {
            log.error("httpClient execute get url:{}, exception:{}",url,e);
        } finally {
            if ( response != null ) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("response close url:{} exception:{}",url,e);
                }
            }
        }
        return null;
    }

    /**
     *
     * @param response
     * @return
     */
    private static String getResponseResult(CloseableHttpResponse response){
        if (response == null || response.getStatusLine() == null) {
            return null;
        }
        int statusCode = response.getStatusLine().getStatusCode();
        if ( statusCode == HttpStatus.SC_OK ) {
            HttpEntity entityRes = response.getEntity();
            if (entityRes != null) {
                try {
                    return EntityUtils.toString(entityRes, "UTF-8");
                } catch (IOException e) {
                    log.error("entityUtils toString parse exception",e);
                }
            }
        }else if ( statusCode == HttpServletResponse.SC_FOUND ){
            Header locationHeader = response.getFirstHeader("Location");
            return locationHeader.getValue();
        }else{
            log.warn("the response code is not success,statusCode:{}",statusCode);
        }
        return null;
    }

    public static String doPost(String apiUrl, Map<String, String> headers, Object params) {
        return doPost(apiUrl, headers, params, true);
    }

    public static String doPost(String apiUrl, Map<String, String> headers, Object params, boolean paramsFormatStringEntity){
        return doPost(apiUrl, Collections.EMPTY_MAP, headers, params, paramsFormatStringEntity);
    }

    public static String doPost(String apiUrl, Map<String, String> queryParams, Map<String, String> headers, Object params) {
        return doPost(apiUrl, queryParams, headers, params, true);
    }

    public static String doPost(String apiUrl, Map<String, String> queryParams, Map<String, String> headers, Object params, boolean paramsFormatStringEntity) {
        HttpPost httpPost = null;
        if(null != queryParams && queryParams.size() > 0){
            try{
                URIBuilder uriBuilder = new URIBuilder(apiUrl);
                for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
                String uri = uriBuilder.build().toString();
                httpPost = new HttpPost(uri);
            }catch (Exception e){
                log.error("error when process http post url:{},exception:{}",apiUrl,e);
                return null;
            }
        }else{
            httpPost = new HttpPost(apiUrl);
        }


        httpClient = getHttpClient();

        if ( headers != null && headers.size() > 0 ) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }

        HttpEntity entityReq;
        if (paramsFormatStringEntity) {
            httpPost.addHeader(HTTP.CONTENT_TYPE, CONTENT_JSON);
            entityReq = getUrlEncodedFormStringEntity(params);
        } else {
            httpPost.addHeader(HTTP.CONTENT_TYPE, CONTENT_X_WWW_FORM_URLENCODED);
            entityReq = getUrlEncodedFormNameValuePairEntity(params);
        }
        httpPost.setEntity(entityReq);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);

            return getResponseResult(response);
        } catch (IOException e) {
            log.error("httpClient execute post url:{},exception:{}",apiUrl,e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("response close url:{},exception:{}",apiUrl,e);
                }
            }
        }
        return null;
    }

    private static HttpEntity getUrlEncodedFormStringEntity(Object params) {
        if (params == null) {
            return null;
        }
        if(params instanceof Map){
            Map<String, Object> paramValues = (Map) params;
            if (paramValues == null || paramValues.size() == 0 ) {
                return null;
            }
            JSONObject pairList = new JSONObject();
            for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
                if(null != entry.getValue()){
                    pairList.put(entry.getKey(), entry.getValue());
                }
            }
            StringEntity entity = new StringEntity(pairList.toString(), Consts.UTF_8);
            entity.setContentType("application/json");
            return entity;
        }else{
            StringEntity entity = new StringEntity(params.toString(), Consts.UTF_8);
            entity.setContentType("application/json");
            return entity;
        }
    }

    private static HttpEntity getUrlEncodedFormNameValuePairEntity(Object params) {
        if ( params == null) {
            return null;
        }
        if(params instanceof Map){
            Map<String, Object> paramValues = (Map) params;

            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
                String value;
                Object obj = entry.getValue();
                if(obj == null){
                    continue;
                }
                if (!(obj instanceof String)) {
                    value = JSONObject.toJSONString(obj);
                } else {
                    value = (String) obj;
                }
                if(StringUtils.isNotBlank(value)){
                    nameValuePairList.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }

            return new UrlEncodedFormEntity(nameValuePairList, Consts.UTF_8);
        }else{
            throw new IllegalArgumentException("params not support, params:" + params.toString());
        }
    }

    private static String getUrlWithParams(String url, Map<String, Object> params) {
        boolean first = true;
        StringBuilder sb = new StringBuilder(url);
        for (Map.Entry<String,Object> entry : params.entrySet()) {
            char ch = '&';
            if(null == entry.getValue()){
                continue;
            }

            if (first == true) {
                ch = '?';
                first = false;
            }

            String value = entry.getValue().toString();

            try {
                String sval = URLEncoder.encode(value, "UTF-8");
                sb.append(ch).append(entry.getKey()).append("=").append(sval);
            } catch (UnsupportedEncodingException e) {
                log.error("unsupportedEncodingException exception",e);
            }
        }
        return sb.toString();
    }


    public static void shutdown() {
        if(idleThread != null){
            idleThread.shutdown();
        }
    }


    /**
     * 清理线程, 定期主动处理过期/空闲连接
     * 当流量为0时, 你会发现存在处于ClOSE_WAIT的连接. 由于httpclient清理过期/被动关闭的socket,是采用懒惰清理的策略.
     * 它是在连接从连接池取出使用的时候, 检测状态并做相应处理. 如果没有流量, 那这些socket将一直处于CLOSE_WAIT(半连接的状态), 系统资源被浪费
     */
    private static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean exitFlag = false;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            this.connMgr = connMgr;
            setDaemon(true);
        }

        @Override
        public void run() {
            while (!this.exitFlag) {
                synchronized (this) {
                    try {
                        this.wait(2000);
                    } catch (InterruptedException e) {
                        log.error("thread interruptedException",e);
                    }
                }
                /**
                 * 关闭失效的连接
                 */
                connMgr.closeExpiredConnections();

                /**
                 * 可选的, 关闭30秒内不活动的连接
                 */
                connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
            }
        }

        public void shutdown() {
            this.exitFlag = true;
            synchronized (this) {
                notify();
            }
        }
    }

}