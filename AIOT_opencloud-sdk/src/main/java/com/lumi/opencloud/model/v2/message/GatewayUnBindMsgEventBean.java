package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 网关解绑绑定通知
 */
@Data
public class GatewayUnBindMsgEventBean implements Serializable {
    private static final long serialVersionUID = -183860211657015295L;

    private String did;

    private int options;

}
