package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/24 10:52 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Getter
@Setter
public class ResourceStatisticsQueryRequest extends BaseRequest {

    @NotBlank(message = "did 不能为空")
    private String did;

    @NotBlank(message = "property 不能为空")
    private String attr;

    public static final int SIZE_MAX = 300;
    public static final int SIZE_MIN = 10;
    public static final int SIZE_DEFAULT = 100;

    @Max(value = SIZE_MAX, message = "当前页最大不能超过300")
    @Min(value = SIZE_MIN, message = "当前页不能少于10")
    private Integer size;

    /**
     * 聚合粒度 OpenCloudUaConstants.DimensionEnum
     */
    @NotBlank(message = "dimension 不能为空")
    private String dimension;

    /**
     * 聚合类型 OpenCloudUaConstants.AggregationTagEnum
     */
    private Integer aggrType;

    /**
     * 是否需要数据空数据填充
     */
    private Boolean needPadding;

    /**
     * 开始时间戳
     */
    private String startTime;

    /**
     * 结束时间戳
     */
    private String endTime;

    @Override
    public String uri() {
        return "/resource/statistics/query";
    }
}