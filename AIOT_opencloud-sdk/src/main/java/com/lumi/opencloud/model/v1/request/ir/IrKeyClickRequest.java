package com.lumi.opencloud.model.v1.request.ir;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 4:54 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Setter
@Getter
public class IrKeyClickRequest extends BaseRequest {
    /**
     * 当还没有遥控器did时传入网关did，有则传遥控器did
     */
    private String did;

    /**
     * 当为空调伴侣匹配时，该字段必填
     */
    private Integer brandId;

    /**
     * 当为空调伴侣时必填
     * 当为 1 时表示为空调伴侣的匹配调用， 0表示红外码控制调用
     */
    private Integer isAcMatch;

    private Integer controllerId;

    private String keyId;

    private String acKey;

    @Override
    public String uri() {
        return "/controller/key/click";
    }
}