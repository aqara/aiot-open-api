package com.lumi.opencloud.controller.v1;

import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.OpenCloudUaConstants;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.model.v1.message.EventMessageBean;
import com.lumi.opencloud.model.v1.message.ResourceMessageBean;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.FilterContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/18 22:58
 * @description
 */
@RestController
@RequestMapping(path = "/v1.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageV1ProcessTest {
    private static Logger log = LoggerFactory.getLogger(MessageV1ProcessTest.class);

    @PostMapping("/message/receive")
    public Map<String,Object> receivePropertiesMsg(HttpServletRequest servletRequest)  {
        String appId = servletRequest.getHeader(CommonRequest.REQUEST_HEADER_APPID);
        String time = servletRequest.getHeader(CommonRequest.REQUEST_HEADER_TIME);
        String sign = servletRequest.getHeader(CommonRequest.REQUEST_HEADER_SIGN);

        Map<String,Object> retMap = new HashMap<>();

        try{
            ServletInputStream servletInputStream = servletRequest.getInputStream();
            String request =  StreamUtils.copyToString(servletInputStream, Charset.forName("UTF-8"));
            log.info("message receive data :{}",request);

            JSONObject requestObj = JSONObject.parseObject(request);
            String echostr = requestObj.getString("echostr");
            String msgType = requestObj.getString("msgType");

            String appKey = TestConstants.Appkey;
            int securityMode = TestConstants.SecurityMode;


            //校验签名
            Map<String,String> headerMap = new HashMap<>();
            headerMap.put(CommonRequest.REQUEST_HEADER_APPID,appId);
            headerMap.put(CommonRequest.REQUEST_HEADER_TIME,time);
            String genSign = FilterContext.createSign(headerMap,appKey,false);
            if(!StringUtils.equals(sign,genSign)){
                log.error("sign is not correct,{},{}",sign,genSign);
                retMap.put("code",100);
                retMap.put("message","sign is not correct");
                return retMap;
            }

            if(StringUtils.isNotEmpty(echostr)){
                retMap = receiveTestMsg(securityMode,appKey,echostr);
            }else if(StringUtils.isNotEmpty(msgType)){
                receiveMsg(securityMode,appKey,requestObj);
                retMap.put("code",0);
            }
            return retMap;

        }catch (Exception e){
            log.error("Exception :{}",e);
            retMap.put("code",-1);
            return retMap;
        }
    }

    /**
     * 检验url可用
     * @param securityMode
     * @param appKey
     * @param echostr
     * @return
     */
    private Map<String,Object> receiveTestMsg(int securityMode,String appKey,String echostr) throws Exception {
        Map<String,Object> retMap = new HashMap<>();
        if(securityMode == 0){
            retMap.put("code",0);
            retMap.put("result",echostr);
            log.info("明文模式返回：{}",retMap);
        }else if(securityMode == 2){
            String dechostr = AESUtil.decryptCbc(echostr, appKey.getBytes("utf-8"));
            retMap.put("code",0);
            retMap.put("result",dechostr);
            log.info("加密模式返回：{}",retMap);
            return retMap;
        }
        return retMap;
    }

    /**
     * 接收消息
     * @param securityMode
     * @param appKey
     * @param requestObj
     * @return
     */
    private void receiveMsg(int securityMode,String appKey,JSONObject requestObj) throws Exception {
        String msgType = requestObj.getString("msgType");
        String data = null;
        if(securityMode == 0){
            data = requestObj.getString("data");
            log.info("subscriber demo receive msgType: {},data: {}",msgType,data);
        }else if(securityMode == 2){
            String enData = requestObj.getString("data");
            data = AESUtil.decryptCbc(enData, AESUtil.getAESKey(appKey));
            log.info("subscriber demo receive msgType: {},data: {}",msgType,data);
        }

        if(StringUtils.isBlank(data)){
            return;
        }

        if(StringUtils.equals(msgType, OpenCloudUaConstants.PushMsgTypeV1Enum.EVENT.getDesc())){
            EventMessageBean eventMessageBean = JSONObject.parseObject(data, EventMessageBean.class);
            log.info("msg bean:{}",eventMessageBean.toString());
        }

        if(StringUtils.equals(msgType, OpenCloudUaConstants.PushMsgTypeV1Enum.RESOURCE.getDesc())){
            ResourceMessageBean resourceMessageBean = JSONObject.parseObject(data, ResourceMessageBean.class);
            log.info("msg bean:{}",resourceMessageBean.toString());
        }

    }
}
