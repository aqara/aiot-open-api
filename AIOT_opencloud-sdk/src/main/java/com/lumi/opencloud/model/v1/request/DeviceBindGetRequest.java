package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/24 9:45 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class DeviceBindGetRequest extends BaseRequest {

    private String positionId;

    private String connectType = "lumi";

    private String userId;

    private Integer lang;

    @Override
    public String uri() {
        return "/device/bind/get";
    }
}