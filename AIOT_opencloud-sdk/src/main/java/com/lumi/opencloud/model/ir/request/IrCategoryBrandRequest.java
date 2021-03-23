package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 3:24 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class IrCategoryBrandRequest extends BaseRequest {

    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String uri() {
        return "/category/brands";
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("categoryId",categoryId);
        return paramsMap;
    }
}