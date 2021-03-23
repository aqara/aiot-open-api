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
 * @Date : 2021/3/23 3:27 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrKeyInfoRequest extends BaseRequest {

    private String did;

    @Override
    public String uri() {
        return "/ircode/key/info";
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        return paramsMap;
    }
}