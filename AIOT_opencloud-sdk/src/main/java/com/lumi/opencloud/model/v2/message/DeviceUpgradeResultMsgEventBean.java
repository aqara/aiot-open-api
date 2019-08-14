package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 设备升级结果通知
 */
@Data
public class DeviceUpgradeResultMsgEventBean implements Serializable {
    private static final long serialVersionUID = 2382803108398320337L;

    private String did;

    private Integer result;

    private String firmwareVersion;
}
