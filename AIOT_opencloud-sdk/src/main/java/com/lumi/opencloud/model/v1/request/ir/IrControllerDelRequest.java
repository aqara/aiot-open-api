package com.lumi.opencloud.model.v1.request.ir;

import com.lumi.opencloud.common.BaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 4:04 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class IrControllerDelRequest extends BaseRequest {

    private String did;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public String uri() {
        return "/controller/del";
    }
}