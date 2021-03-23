package com.lumi.opencloud.model.v1.request.ir;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 5:23 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrRemoteFunctionRequest extends BaseRequest {

    /**
     * did or remoteId choose one of them
     */
    private String did;

    private int remoteId;

    @Override
    public String uri() {
        return "/controller/remote/functions";
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        paramsMap.put("remoteId",remoteId);
        return paramsMap;
    }
}