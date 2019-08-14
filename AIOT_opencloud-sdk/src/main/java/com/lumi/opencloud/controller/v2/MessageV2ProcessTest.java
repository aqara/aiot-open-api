package com.lumi.opencloud.controller.v2;

import com.alibaba.fastjson.JSON;
import com.lumi.opencloud.common.OpenCloudUaConstants;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.model.v2.message.*;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author lvyl
 * @date 2018/12/29 17:25
 * @description
 */
@RestController
@RequestMapping(path = "/v2.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageV2ProcessTest {
    private static Logger log = LoggerFactory.getLogger(MessageV2ProcessTest.class);

    @PostMapping("/message/properties/receive")
    public String receivePropertiesMsg(HttpServletRequest httpServletRequest)  {
        try{
            ServletInputStream servletInputStream = httpServletRequest.getInputStream();
            String reqBody =  StreamUtils.copyToString(servletInputStream, Charset.forName("UTF-8"));
            log.info("message resource receive data :{}",reqBody);

            String appKey = TestConstants.Appkey;

            String result  = AESUtil.decryptCbc(reqBody, AESUtil.getAESKey(appKey));

            if(StringUtils.isBlank(result)) {
                log.error("can not decrypt message:"+reqBody);
                return "0";
            }
            List<PropertiesMsgBean> msgs = JSON.parseArray(result, PropertiesMsgBean.class);
            /*资源消息处理-建议异步处理及时返回*/
            log.info("message resource receive, data: {}", result);
            return "0";
        }catch (Exception e){
            log.error("receivePropertiesMsg Exception：",e);
            return "-1";
        }
    }


    @PostMapping("/message/event/receive")
    public String receiveEventMsg(HttpServletRequest httpServletRequest)  {
        try{
            ServletInputStream servletInputStream = httpServletRequest.getInputStream();
            String reqBody =  StreamUtils.copyToString(servletInputStream, Charset.forName("UTF-8"));
            log.info("message event receive, data before:{}",reqBody);

            String appKey = TestConstants.Appkey;

            String result  = AESUtil.decryptCbc(reqBody, AESUtil.getAESKey(appKey));

            if(StringUtils.isBlank(result)) {
               log.error("can not decrypt message:"+reqBody);
               return "0";
            }
            /*事件消息处理*/
            log.info("message event receive, data: {}", result);
            EventMsgCommonBean msg = JSON.parseObject(result, EventMsgCommonBean.class);
            OpenCloudUaConstants.PushMsgEventEnum pushMsgEventEnum = OpenCloudUaConstants.getPushMsgEventEnum(msg.getEventType());
            switch(pushMsgEventEnum){
                /*gateway connect cloud notify*/
                case GATEWAY_BIND:
                    GatewayBindMsgEventBean gatewayBindMsgEventBean = MapUtils.transMap2Bean(msg.getData(), GatewayBindMsgEventBean.class);
                    log.info("gateway bind notify, bean:{}", gatewayBindMsgEventBean);
                    break;

                /*gateway unbind cloud notify*/
                case GATEWAY_UNBIND:
                    GatewayUnBindMsgEventBean gatewayUnBindMsgEventBean = MapUtils.transMap2Bean(msg.getData(), GatewayUnBindMsgEventBean.class);
                    log.info("gateway unbind notify, bean:{}", gatewayUnBindMsgEventBean);
                    break;

                /*gateway device online/offline notify,will sub device*/
                case GATEWAY_ONLINE:
                case GATEWAY_OFFLINE:
                    GatewayOnOfflineMsgEventBean gatewayOnOfflineMsgEventBean = MapUtils.transMap2Bean(msg.getData(), GatewayOnOfflineMsgEventBean.class);
                    log.info("gateway on-offline notify, bean:{}", gatewayOnOfflineMsgEventBean);
                    break;

                /*sub device bind/unbind notify*/
                case SUB_DEVICE_BIND:
                case SUB_DEVICE_UNBIND:
                    SubDeviceBindMsgEventBean subDeviceBindMsgEventBean = MapUtils.transMap2Bean(msg.getData(), SubDeviceBindMsgEventBean.class);
                    log.info("sub device bind/unbind notify, bean:{}", subDeviceBindMsgEventBean);
                    break;

                /*sub device online/offline notify*/
                case SUB_DEVICE_ONLINE:
                case SUB_DEVICE_OFFLINE:
                    SubDeviceOnOfflineMsgEventBean subDeviceOnOfflineMsgEventBean = MapUtils.transMap2Bean(msg.getData(), SubDeviceOnOfflineMsgEventBean.class);
                    log.info("sub device on-offline notify, bean:{}", subDeviceOnOfflineMsgEventBean);
                    break;

                /*device upgrade result notify*/
                case DEV_UPGRADE_RESULT:
                    DeviceUpgradeResultMsgEventBean deviceUpgradeResultMsgEventBean = MapUtils.transMap2Bean(msg.getData(), DeviceUpgradeResultMsgEventBean.class);
                    log.info("device upgrade result notify, bean:{}", deviceUpgradeResultMsgEventBean);
                    break;

                /*device upgrade progress notify*/
                case DEV_UPGRADE_PROGRESS:
                    DeviceUpgradeProgressMsgEventBean deviceUpgradeProgressMsgEventBean = MapUtils.transMap2Bean(msg.getData(), DeviceUpgradeProgressMsgEventBean.class);
                    log.info("device upgrade progress notify, bean:{}", deviceUpgradeProgressMsgEventBean);
                    break;

                default:
                    log.warn("message event not support this notify, msg:{}", result);
            }
            return "0";
        }catch (Exception e){
            log.error("receiveEventMsg Exception：",e);
            return "-1";
        }
    }

}
