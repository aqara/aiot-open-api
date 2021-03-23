package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/23 3:23 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrKeyUpdateRequest extends BaseRequest {

    private String did;

    private String keyId;

    private String keyName;

    @Override
    public String uri() {
        return "/ircode/key/update";
    }
}