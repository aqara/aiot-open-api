package com.lumi.opencloud.model.v1.response;

import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 17:59
 * @description
 */
@Data
public class IftttListQueryResponse {

    private int totalCount;

    private List<IftttListQueryInfo> data;
}
