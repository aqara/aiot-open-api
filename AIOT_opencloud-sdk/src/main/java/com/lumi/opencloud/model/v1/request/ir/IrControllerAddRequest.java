package com.lumi.opencloud.model.v1.request.ir;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 4:00 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
@Setter
@Getter
public class IrControllerAddRequest extends BaseRequest {
    /**
     * 遥控器对应的网关ID
     */
    @NotEmpty(message = "parentId is empty")
    private String parentId;

    /**
     * 设备类别
     * 参数可以从红外服务中得到，例子中TV  2
     */
    @NotNull(message = "categoryId is empty")
    private Integer categoryId;

    /**
     * 遥控器名字
     */
    @NotEmpty(message = "name is empty")
    private String name;

    /**
     *  对于机顶盒需要Lineup id
     */
    private String lineupId;

    /**
     * 遥控器品牌
     */
    private Integer brandId;

    /**
     * 遥控器id
     */
    @NotNull(message = "controllerId is empty")
    private Integer controllerId;

    /**
     * 位置信息
     */
    @NotEmpty(message = "positionId is empty")
    private String positionId;

    @Override
    public String uri() {
        return null;
    }
}