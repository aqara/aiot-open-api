package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 子设备绑定解绑通知
 */
@Data
public class SubDeviceBindMsgEventBean implements Serializable {
    private static final long serialVersionUID = -6965145878871280501L;

    private String parentDid;

    private String did;

    /**
     * 设备模型
     */
    private String model;

    /**
     * 版本号
     */
    private String firmwareVersion;
}
