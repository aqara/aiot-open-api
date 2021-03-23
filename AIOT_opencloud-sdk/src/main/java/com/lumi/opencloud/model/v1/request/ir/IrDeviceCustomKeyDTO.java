package com.lumi.opencloud.model.v1.request.ir;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 7:30 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Setter
@Getter
public class IrDeviceCustomKeyDTO implements Serializable {

    private static final long serialVersionUID = -682137315591531790L;

    /******红外码key信息*****/
    /**
     * 键值名称（键值id需要再ir模块另外生成）
     */
    @NotEmpty(message = "keyName is empty")
    private String keyName;

    @NotEmpty(message = "keyId is empty")
    private String keyId;

    /**
     * 红外码值
     */
    @NotEmpty(message = "ircode is empty")
    private String ircode;

    /**
     * 频率
     */
    private String freq;

}