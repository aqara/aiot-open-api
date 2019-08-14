package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 设备升级进度通知
 */
@Data
public class DeviceUpgradeProgressMsgEventBean implements Serializable {
    private static final long serialVersionUID = 926401060465402798L;

    private Integer progress;

    private String did;
}
