package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/23 2:40 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrKeyAddRequest extends BaseRequest {

    private String did;

    private List<IrDeviceCustomKeyDTO> irCodeInfos;

    @Override
    public String uri() {
        return "/ircode/key/add";
    }
}