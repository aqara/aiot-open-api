package com.lumi.opencloud.model.v2.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class DeviceInfoResponse implements Serializable {

    private static final long serialVersionUID = -7391802667013723274L;

    /**
     * 父设备id
     */
    private String parentDid;

    /**
     * 当前设备id
     */
    private String did;

    /**
     *  设备当前固件版本号
     */
    private String firmwareVersion;

    /**
     * 设备时区
     */
    private String timeZone;

    /**
     * 设备模型
     */
    private String model;

    /**
     * 设备类型：
     * 1-可以挂子设备的网关
     * 2-不可以挂子设备的网关
     * 3-子设备
     */
    private Integer modelType;

    /**
     * 设备状态
     * 0-离线
     * 1-在线
     */
    private Integer state;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
