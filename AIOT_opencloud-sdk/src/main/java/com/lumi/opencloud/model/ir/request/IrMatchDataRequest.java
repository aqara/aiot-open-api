package com.lumi.opencloud.model.ir.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 3:51 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class IrMatchDataRequest extends BaseRequest {
    /**
     * 1 类别品牌查询
     * 2 运营商查询
     * 3 IPTV查询
     */
    private Integer type;
    /**
     * 类别
     */
    private String categoryId;

    /**
     * 品牌
     */
    private String brandId;

    /**
     *城市
     */
    private String cityId;

    /**
     * 运营商
     */
    private String spId;

    @Override
    public String uri() {
        return "/match/data";
    }
}