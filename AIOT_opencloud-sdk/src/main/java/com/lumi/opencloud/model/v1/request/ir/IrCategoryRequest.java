package com.lumi.opencloud.model.v1.request.ir;

import com.lumi.opencloud.common.BaseRequest;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 3:01 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class IrCategoryRequest extends BaseRequest {
    @Override
    public String uri() {
        return "/categories";
    }
}