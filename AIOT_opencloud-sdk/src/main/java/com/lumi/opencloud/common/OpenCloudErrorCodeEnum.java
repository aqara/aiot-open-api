package com.lumi.opencloud.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: zzm
 * @Date: 2019/06/04
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum OpenCloudErrorCodeEnum{
    SUCCESS(0, "Success"),
    ERROR_TIMEOUT(100, "Timeout"),
    ERROR_SERVER_BUSY(104, "Server busy"),
    ERROR_DATA_PACKAGE_IS_EXPIRED(105, "Data package has expired"),
    ERROR_ILLEGAL_SIGN(106, "Invalid sign"),

    ERROR_REQUEST_PATH(301, "Request path error"),
    ERROR_REQUEST_PARAMS(302, "Params error"),
    ERROR_PARAMS_TYPE(303, "Request params type error"),
    ERROR_NOT_SUPPORT_METHOD(304, "Request method not support"),

    ERROR_SERVER_INTERNAL(500, "Service impl error"),
    ERROR_PROXY(501, "Service proxy error"),

    ERROR_DEVICE_NO_REG(601, "Device not active"),

    ERROR_DEVICE_NO_ONLINE(602, "Device is offline"),
    ERROR_DEVICE_PERMISSION_DENIED(603, "Device permission denied"),
    ERROR_REQUEST_GATEWAY_NOT_RESPONSE(612, "Gateway request not response"),
    ERROR_SUB_DEVICE_NOT_SUPPORT_OPERATE(638, "Sub device not support this operation"),
    ERROR_DEVICE_NOT_SUB_DEVICE(639, "Device cannot mount sub device"),

    ERROR_LINKAGE_NOT_EXIST(1201, "Linkage not exist"),
    ERROR_SCENE_NOT_EXIST(1202, "Scene not exist"),
    IFTTT_EXEC_CONDITION_FALSE(1203, "Ifttt execute condition not satisfied"),
    CONNECT_DEVICE_ERROR(1209, "device service offline"),
    IFTTT_NOT_EXIST_ACTION_DEFINITION(1210, "This action not definition"),
    IFTTT_NOT_EXIST_TRIGGER_DEFINITION(1211, "This trigger not definition"),
    IFTTT_NOT_ACTION(1212, "Action is empty"),
    IFTTT_EXEC_FAILED(1221, "Ifttt execute failed"),
    IFTTT_EXEC_NO_CLOUD(1222, "Ifttt execute not cloud"),


    PROPERTY_READ_UNABLE(1529, "Property read unable"),
    PROPERTY_WRITE_UNABLE(1530, "Property write unable"),
    PROPERTY_ILLEGAL(1531, "Property illegal"),
    PROPERTY_VALUE_ILLEGAL(1532, "Property value illegal"),

    ;

    private int code;
    private String desc;

}
