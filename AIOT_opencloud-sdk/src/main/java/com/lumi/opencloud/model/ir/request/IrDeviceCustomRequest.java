package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 7:31 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Data
public class IrDeviceCustomRequest extends BaseRequest {

    /**
     * 遥控器对应的网关ID
     */
    @NotEmpty(message = "parentId is empty")
    private String parentId;

    /**
     * 遥控器名字
     */
    @NotEmpty(message = "name is empty")
    private String name;

    /**
     * 位置信息
     */
    @NotEmpty(message = "positionId is empty")
    private String positionId;

    /******红外码key信息*****/
    @Valid
    @NotEmpty(message = "irCodeInfos can not be empty")
    private List<IrDeviceCustomKeyDTO> irCodeInfos;

    @Override
    public String uri() {
        return "/custom/controller/add";
    }
}