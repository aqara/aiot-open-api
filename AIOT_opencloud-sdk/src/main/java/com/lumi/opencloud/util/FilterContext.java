package com.lumi.opencloud.util;

import lombok.extern.slf4j.Slf4j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hongsheng.wei
 * @Date: 2018/11/13
 * @Description:
 */
@Slf4j
public class FilterContext {

    /**
     * 生成签名
     *
     * @param parames
     * @return
     */
    public static String createSign(Map<String, String> parames, String appKey, Boolean encode) {
        //sort
        Object[] keys = parames.keySet().toArray();
        Arrays.sort(keys);
        StringBuffer stringBuffer = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                stringBuffer.append("&");
            }
            stringBuffer.append(key).append("=");
            String paramValue = parames.get(key);
            String valueString = "";
            if (null != paramValue) {
                valueString = String.valueOf(paramValue);
            }
            if (encode) {
                try {
                    stringBuffer.append(URLEncoder.encode(valueString, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    log.error("URLEncoder encode error", e);
                }
            } else {
                stringBuffer.append(valueString);
            }
        }
        //append appKey
        String signStr = stringBuffer.append("&").toString().toLowerCase() + appKey;
        try {
            return MD5Util.MD5(signStr);
        } catch (Exception e) {
            log.error("Md5Util MD5 error", e);
        }
        return null;
    }

}
