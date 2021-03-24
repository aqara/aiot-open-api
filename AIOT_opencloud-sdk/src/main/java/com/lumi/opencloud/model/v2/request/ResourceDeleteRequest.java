package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/24 11:31 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class ResourceDeleteRequest extends BaseRequest {

    private Set<String> dids;

    private String startTime;

    private String endTime;

    @Override
    public String uri() {
        return "/properties/delete";
    }
}