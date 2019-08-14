package com.lumi.opencloud.model.v2.message;

import com.lumi.opencloud.model.v2.response.DeviceInfoResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 网关绑定通知
 */
@Data
public class GatewayBindMsgEventBean implements Serializable {

    private static final long serialVersionUID = -5839348398907402297L;

    private String did;

    /**
     * 设备绑定上传的key，用户manager获取对应的用户和位置信息
     */
    private String bindKey;

    /**
     * 设备固件版本
     */
    private String firmwareVersion;

    private String time;

    /**
     * 网关模型
     */
    private String model;

    private Integer modelType;

    private String timeZone;

    private List<DeviceInfoResponse> subInfo;
}
