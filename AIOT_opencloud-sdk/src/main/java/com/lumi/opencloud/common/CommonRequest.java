package com.lumi.opencloud.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.FilterContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: heaven
 * @Date: 2019/6/4 15:04
 * @Version 1.0
 */
public class CommonRequest {
    private static Logger log = LoggerFactory.getLogger(CommonRequest.class);

    public static final String REQUEST_HEADER_APPID = "Appid";

    public static final String REQUEST_HEADER_TOKEN = "Accesstoken";

    public static final String REQUEST_HEADER_LANG = "Lang";

    public static final String REQUEST_HEADER_TIME = "Time";

    public static final String REQUEST_HEADER_PAYLOAD = "Payload";

    public static final String REQUEST_HEADER_SIGN = "Sign";

    /**
     * V2.0 Api header
     * @param body
     * @return
     */
    public static Map<String, String> constructHeaderV2(AiotConfig aiotConfig,String body) {
        Map<String, String> header = new HashMap<>(4);
        header.put(REQUEST_HEADER_APPID, aiotConfig.getAppId());
        header.put(REQUEST_HEADER_TIME, String.valueOf(System.currentTimeMillis()));
        if(StringUtils.isNotBlank(aiotConfig.getLang())){
            header.put(REQUEST_HEADER_LANG, aiotConfig.getLang());
        }

        if(StringUtils.isNotBlank(body)) {
            header.put(REQUEST_HEADER_PAYLOAD,body);
        }

        String sign = FilterContext.createSign(header, aiotConfig.getAppKey(),false);
        header.put(REQUEST_HEADER_SIGN,sign);
        return header;
    }

    /**
     * Result decrypt
     * @param result
     * @param type result type（0-String,1-JSONObject 2-JSONArray）
     * @return
     */
    public static ResponseMsg responseDecode(AiotConfig aiotConfig,String result,int type) throws Exception {
        if(StringUtils.isBlank(result)){
            return ResponseMsg.builder().code(OpenCloudErrorCodeEnum.ERROR_SERVER_INTERNAL.getCode())
                    .message(OpenCloudErrorCodeEnum.ERROR_SERVER_INTERNAL.getDesc()).build();
        }
        ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
        if(responseMsg.getResult() != null){
            String data = AESUtil.decryptCbc(responseMsg.getResult().toString(), AESUtil.getAESKey(aiotConfig.getAppKey()));
            if(responseMsg.getCode() == OpenCloudErrorCodeEnum.SUCCESS.getCode()){
                if(type == 0){
                    responseMsg.setResult(data);
                }else if(type == 1){
                    responseMsg.setResult(JSONObject.parseObject(data));
                }else if(type == 2){
                    responseMsg.setResult(JSONArray.parseArray(data));
                }
            }else {
                responseMsg.setResult(data);
            }
        }
        log.info("common response decode.request:{},return:{}",result, JSON.toJSONString(responseMsg));
        return responseMsg;
    }

    /**
     * V1.0 Api header
     * @return
     */
    public static Map<String, String> constructHeaderV1(AiotConfig aiotConfig) {
        Map<String, String> header = new HashMap<>(4);
        header.put(REQUEST_HEADER_APPID, aiotConfig.getAppId());
        header.put(REQUEST_HEADER_TIME, String.valueOf(System.currentTimeMillis()));
        if(StringUtils.isNotBlank(aiotConfig.getLang())){
            header.put(REQUEST_HEADER_LANG, aiotConfig.getLang());
        }
        header.put(REQUEST_HEADER_TOKEN, aiotConfig.getAccessToken());
        return header;
    }

}
