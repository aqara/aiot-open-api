package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 网关在线离线通知
 */
@Data
public class GatewayOnOfflineMsgEventBean implements Serializable {
    private static final long serialVersionUID = 1371871922862285644L;

    private String did;

    private List<String> subDids;
}
