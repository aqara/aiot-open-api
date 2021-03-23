package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 4:20 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrControllerUpdateRequest extends BaseRequest {

    private String did;

    private String name;

    @Override
    public String uri() {
        return "/controller/update";
    }
}