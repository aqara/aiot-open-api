package com.lumi.opencloud.model.v1.response;

import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 15:57
 * @description
 */
@Data
public class PositionQueryResponse {

    private List<PositionInfoResponse> data;

    private int totalCount;
}
