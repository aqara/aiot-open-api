package com.lumi.opencloud.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
public abstract class OpenCloudUaConstants {

    @Getter
    @AllArgsConstructor
    public enum App3rdDeviceStateEnum{
        ACTIVATED((short) 1, "activated"),
        NOT_ACTIVE((short) 0, "not active");

        private short code;
        private String desc;

    }

    @Getter
    @AllArgsConstructor
    public enum App3rdDeviceGatewayConnectStateEnum{
        NOT_CONNECT((short) 1, "not connect"),
        CONNECT_SUCCESS((short) 0, "connect success");

        private short code;
        private String desc;

    }

    @Getter
    @AllArgsConstructor
    public enum App3rdDeviceGatewayUnbindStateEnum{
        RESTORE((short) 1, "恢复出厂"),
        UNBIND((short) 0, "解绑")
        ;

        private short code;
        private String desc;

    }

    @Getter
    @AllArgsConstructor
    public enum PushMsgEventEnum{
        GATEWAY_BIND("gateway_bind", "网关绑定"),
        GATEWAY_UNBIND("gateway_unbind", "网关解绑"),
        GATEWAY_ONLINE("gateway_online", "网关在线"),
        GATEWAY_OFFLINE("gateway_offline", "网关离线"),
        SUB_DEVICE_BIND("subdevice_bind", "子设备绑定"),
        SUB_DEVICE_UNBIND("subdevice_unbind", "子设备解绑"),
        SUB_DEVICE_ONLINE("subdevice_online", "子设备在线"),
        SUB_DEVICE_OFFLINE("subdevice_offline", "子设备离线"),
        DEV_UPGRADE_PROGRESS("dev_upgrade_progress", "设备升级进度"),
        DEV_UPGRADE_RESULT("dev_upgrade_result", "设备升级结果"),
        /*TODO:下一迭代*/
        IFTTT_LOCALIZE("ifttt_localize", "本地自动化本地完成"),
        IFTTT_LOCALIZE_DELETE("ifttt_localize_delete", "本地自动化清除完成"),

        UN_KNOW("un_know", "未知");

        private String eventType;
        private String desc;

    }

    public static PushMsgEventEnum getPushMsgEventEnum(String eventType){
        for(PushMsgEventEnum pushMsgEventEnum : PushMsgEventEnum.values()){
            if(StringUtils.equals(pushMsgEventEnum.getEventType(), eventType)){
                return pushMsgEventEnum;
            }
        }
        return PushMsgEventEnum.UN_KNOW;
    }

    @Getter
    @AllArgsConstructor
    public enum ProgressEnum {
        /*升级成功*/
        SUCCESS(0, "succ"),
        /*升级中*/
        PROGRESS(1, "upgrade"),
        /*升级失败*/
        FAIL(2, "fail"),
        /*未知*/
        UNKNOW(3, "unknow");

        private int code;
        private String desc;
    }

    @Getter
    public enum PushMsgTypeV1Enum{
        EVENT("device","事件消息"),
        RESOURCE("resource", "资源消息")
        ;

        private String type;
        private String desc;

        PushMsgTypeV1Enum(String type, String desc){
            this.type = type;
            this.desc = desc;
        }
    }
}
