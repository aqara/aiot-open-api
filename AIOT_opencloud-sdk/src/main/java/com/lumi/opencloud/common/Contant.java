package com.lumi.opencloud.common;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/19 6:19 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class Contant {

    /**
     * domain url
     * 各区域请求地址
     */
    public enum Domain{
        /**
         *
         */
        CHINA("https://aiot-open-3rd.aqara.cn"),
        USA("https://aiot-open-usa.aqara.com"),
        EUROPE("https://open-ger.aqara.com"),
        KOREA("https://open-kr.aqara.com"),
        RUSSIA("https://open-ru.aqara.com");

        String url;

        Domain(String url){
            this.url=url;
        }

    }

    /**
     * request url
     * 请求uri
     */
    @Getter
    public enum RequestUri{
        /**
         *
         */
        AUTHORIZE("/authorize/code"),
        TOKEN("/access_token"),
        DEVICE_CHILD_QUERY("/device/child/query"),
        DEVICE_CONNECT("/device/connect"),
        DEVICE_CONNECT_STOP("/device/connect/stop"),
        DEVICE_QUERY("/device/query"),
        DEVICE_UNBIND("/device/unbind"),
        DEVICE_UPDATE("/device/update"),
        IFTTT_ACTION_QUERY("/ifttt/action/query"),
        IFTTT_ADD("/ifttt/add"),
        IFTTT_DELETE("/ifttt/delete"),
        IFTTT_DETAIL("/ifttt/query/detail"),
        IFTTT_ENABLE("/ifttt/enable"),
        IFTTT_LIST_QUERY("/ifttt/query"),
        IFTTT_TRIGGER_QUERY("/ifttt/trigger/query"),
        IFTTT_UPDATE("/ifttt/update"),
        POSITION_ADD("/position/add"),
        POSITION_DELETE("/position/delete"),
        POSITION_QUERY("/position/query"),
        POSITION_UPDATE("/position/update"),
        RES_HIS_QUERY("/resource/history/query"),
        RES_QUERY("/resource/query"),
        RES_SUBSCRIBE("/subscriber/resource"),
        RES_UNSUBSCRIBE("/unsubscriber/resource"),
        RES_UPDATE("/resource/update"),
        SCENE_CREATE("/scene/add"),
        SCENE_DELETE("/scene/delete"),
        SCENE_DETAIL("/scene/query/detail"),
        SCENE_LIST_QUERY("/scene/query"),
        SCENE_RUN("/scene/run"),
        BIND_KEY_GET("/device/bind/get"),
        BIND_KEY_QUERY("/device/bind/query"),
        RESOURCE_STATISTICS("/resource/statistics/query"),

        DEV_BIND_GET("/dev/bind/get"),
        DEV_BIND_QUERY("/dev/bind/query"),
        DEV_CONN_SUB_DEVICE_START("/dev/connect/subdevice/start"),
        DEV_CONN_SUB_DEVICE_STOP("/dev/connect/subdevice/stop"),
        DEV_QUERY_DETAIL("/dev/query/detail"),
        DEV_TIMEZONE_UPDATE("/dev/timezone/update"),
        DEV_UNBIND("/dev/unbind"),
        OTA_FIRMWARE_UPGRADE("/ota/upgrade/firmware"),
        OTA_FIRMWARE_QUERY("/ota/firmware/query"),
        PROPERTIES_QUERY("/properties/query"),
        PROPERTIES_WRITE("/properties/write"),
        PROPERTIES_HIS_QUERY("/properties/history/query"),
        PROPERTIES_DELETE("/properties/delete"),
        PROPERTIES_STATISTICS("/properties/statistics/query"),
        IFTTT_SCENE_CREATE("/ifttt/scene/create"),
        IFTTT_SCENE_DELETE("/ifttt/scene/delete"),
        IFTTT_SCENE_UPDATE("/ifttt/scene/update"),
        IFTTT_SCENE_QUERY_DETAIL("/ifttt/scene/query/detail"),
        IFTTT_SCENE_RUN("/ifttt/scene/run"),
        IFTTT_SCENE_SUBJECT_QUERY("/ifttt/scene/subject/query"),
        IFTTT_SCENE_TRY("/ifttt/scene/try"),
        IFTTT_ACTION_DEF_QUERY("/ifttt/action/definition/query"),
        IFTTT_CREATE("/ifttt/create"),
        IFTTT_STATE_UPDATE("/ifttt/state/update"),
        IFTTT_LINKAGE_QUERY_DETAIL("/ifttt/query/linkage/detail"),
        IFTTT_SUBJECT_QUERY("/ifttt/subject/query"),
        IFTTT_TRIGGER_DEF_QUERY("/ifttt/trigger/definition/query"),

        IR_AC_STATE("/ircode/ac/state"),
        IR_CATEGORY_BRAND("/category/brands"),
        IR_CATEGORY("/categories"),
        IR_CONTROLLER_ADD("/controller/add"),
        IR_CONTROLLER_DELETE("/controller/del"),
        IR_CONTROLLER_INFO("/controller/info"),
        IR_CONTROLLER_KEYS("/controller/keys"),
        IR_CONTROLLER_LIST("/controller/list"),
        IR_CONTROLLER_UPDATE("/controller/update"),
        IR_CUSTOM_CONTROLLER_ADD("/custom/controller/add"),
        IR_KEY_ADD("/ircode/key/add"),
        IR_KEY_CLICK("/controller/key/click"),
        IR_KEY_DEL("/ircode/key/del"),
        IR_KEY_INFO("/ircode/key/info"),
        IR_KEY_UPDATE("/ircode/key/update"),
        IR_LEARN_CANCEL("/ircode/learn/cancel"),
        IR_LEARN_RESULT("/ircode/learn/result"),
        IR_LEARN_START("/ircode/learn/start"),
        IR_MATCH_DATA("/match/data"),
        IR_REMOTE_FUNCTION("/controller/remote/functions")
        ;

        String url;

        RequestUri(String url){
            this.url=url;
        }

        public static RequestUri getEnum(String url){
            for (RequestUri value : RequestUri.values()) {
                if (StringUtils.equals(url,value.getUrl())){
                    return value;
                }
            }
            return null;

        }

    }
}