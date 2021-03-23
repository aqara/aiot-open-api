package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 7:24 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrLearnResultRequest extends BaseRequest {

    private String did;

    private String keyId;

    @Override
    public String uri() {
        return "/ircode/learn/result";
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        paramsMap.put("keyId",keyId);
        return paramsMap;
    }
}