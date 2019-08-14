package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 子设备在线离线通知
 */
@Data
public class SubDeviceOnOfflineMsgEventBean implements Serializable {
    private static final long serialVersionUID = -8575588300740004950L;

    private String parentDid;

    private String did;
}
