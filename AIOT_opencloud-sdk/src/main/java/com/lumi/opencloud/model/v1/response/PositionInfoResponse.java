package com.lumi.opencloud.model.v1.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/17 15:57
 * @description
 */
@Data
public class PositionInfoResponse {

    private String positionId;

    private String positionName;

    private String description;

    private String createTime;
}
