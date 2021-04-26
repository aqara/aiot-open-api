package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.AccessTokenRequest;
import com.lumi.opencloud.model.v1.request.AuthorizeRequest;
import com.lumi.opencloud.model.v1.response.AccessTokenResponse;
import com.lumi.opencloud.util.MD5Util;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author lvyl
 * @date 2019/7/30 20:01
 * @description oauth2授权
 */
public class OauthManager {

    private static Logger log = LoggerFactory.getLogger(OauthManager.class);

    /**
     * 	Authorize授权
     * Query device
     * @return ResponseMsg
     */
    public static ResponseMsg authorize(String domain,AuthorizeRequest request) {
        try {
            request.setResponseType(AuthorizeRequest.RESPONSE_TYPE);
            String url = domain + request.uri();
            if (StringUtils.isNotBlank(request.getPassword())){
                request.setPassword(MD5Util.MD5(request.getPassword()));
            }
            String result = PooledHttpClientUtils.doPost(url, null, JSON.toJSONString(request));
            log.info("authorize result:{}", result);
            return JSONObject.parseObject(result, ResponseMsg.class);
        } catch (Exception e) {
            log.error("authorize error:", e);
        }

        return null;
    }

    /**
     * 	accessToken获取
     * Query device
     * @return ResponseMsg
     */
    public static ResponseMsg accessToken(String domain,AccessTokenRequest request) {
        try {

            String url = domain + request.uri();
            String result = PooledHttpClientUtils.doPost(url, new HashMap<>() , request.getParamsMap());
            log.info("accessToken result:{}", result);


            return JSONObject.parseObject(result, ResponseMsg.class);
        } catch (Exception e) {
            log.error("accessToken error:", e);
        }

        return null;
    }
}
