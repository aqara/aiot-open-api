package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.AccessTokenRequest;
import com.lumi.opencloud.model.v1.request.AuthorizeRequest;
import com.lumi.opencloud.model.v1.response.AccessTokenResponse;
import com.lumi.opencloud.util.PooledHttpClientUtils;
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
    public static String authorize(AuthorizeRequest request) {
        try {
            request.setResponse_type(AuthorizeRequest.RESPONSE_TYPE);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, request.getParamsMap(),new HashMap<>(),request.getBodyMap(),false);
            log.info("authorize result:{},request:{}", result, JSON.toJSONString(request));

            return result;
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
    public static AccessTokenResponse accessToken(AccessTokenRequest request) {
        try {

            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, new HashMap<>() , request.getParamsMap(),false);
            log.info("accessToken result:{},request:{}", result,JSON.toJSONString(request));

            AccessTokenResponse response = JSONObject.parseObject(result,AccessTokenResponse.class);
            return response;
        } catch (Exception e) {
            log.error("accessToken error:", e);
        }

        return null;
    }
}
