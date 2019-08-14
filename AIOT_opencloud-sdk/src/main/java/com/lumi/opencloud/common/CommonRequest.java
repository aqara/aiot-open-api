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

    public static final String REQUEST_HEADER_SIGN = "Sign";

    public static final String REQUEST_HEADER_TOKEN = "Accesstoken";

    public static final String REQUEST_HEADER_PAYLOAD = "Payload";

    public static final String REQUEST_HEADER_LANG = "Lang";

    public static final String REQUEST_HEADER_TIME = "Time";

    /**
     * V2.0 Api header
     * @param body
     * @return
     */
    public static Map<String, String> constructHeaderV2(String body) {
        Map<String, String> header = new HashMap<>(4);
        header.put(REQUEST_HEADER_APPID, AiotConfig.getAppid());
        header.put(REQUEST_HEADER_TIME, String.valueOf(System.currentTimeMillis()));
        if(StringUtils.isNotBlank(AiotConfig.getLang())){
            header.put(REQUEST_HEADER_LANG, AiotConfig.getLang());
        }
        if(StringUtils.isNotBlank(body)) {
            header.put(REQUEST_HEADER_PAYLOAD,body);
        }

        String sign = FilterContext.createSign(header, AiotConfig.getAppkey(),false);
        header.put(REQUEST_HEADER_SIGN,sign);
        return header;
    }

    /**
     * Result 解码
     * @param result
     * @param type result类型（0-String,1-JSONObject 2-JSONArray）
     * @return
     */
    public static ResponseMsg responseDecode(String result,int type) throws Exception {
        if(StringUtils.isBlank(result)){
            return ResponseMsg.builder().code(OpenCloudErrorCodeEnum.ERROR_SERVER_INTERNAL.getCode())
                    .message(OpenCloudErrorCodeEnum.ERROR_SERVER_INTERNAL.getDesc()).build();
        }
        ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
        if(responseMsg.getResult() != null){
            String data = AESUtil.decryptCbc(responseMsg.getResult().toString(), AESUtil.getAESKey(AiotConfig.getAppkey()));
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
    public static Map<String, String> constructHeaderV1() {
        Map<String, String> header = new HashMap<>(4);
        header.put(REQUEST_HEADER_APPID, AiotConfig.getAppid());
        header.put(REQUEST_HEADER_TIME, String.valueOf(System.currentTimeMillis()));
        if(StringUtils.isNotBlank(AiotConfig.getLang())){
            header.put(REQUEST_HEADER_LANG, AiotConfig.getLang());
        }
        header.put(REQUEST_HEADER_TOKEN, AiotConfig.getAccesstoken());

        String sign = FilterContext.createSign(header, AiotConfig.getAppkey(),false);
        header.put(REQUEST_HEADER_SIGN,sign);
        return header;
    }

}
