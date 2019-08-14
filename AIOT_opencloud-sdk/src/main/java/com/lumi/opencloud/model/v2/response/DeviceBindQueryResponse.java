package com.lumi.opencloud.model.v2.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description:
 */
@Data
public class DeviceBindQueryResponse implements Serializable{

    private static final long serialVersionUID = 1364159969425185882L;

    private String did;

    /**
     * 设备绑定上传的key，用户manager获取对应的用户和位置信息
     */
    private String bindKey;

    /**
     * 设备固件版本
     */
    private String firmwareVersion;

    /**
     * 入网时间
     */
    private String time;

    /**
     * 网关模型
     */
    private String model;

    /**
     * 设备类型
     */
    private Integer modelType;

    /**
     * 时区
     */
    private String timeZone;

    /**
     * 子设备列表
     */
    List<DeviceInfoResponse> subInfo;

}
