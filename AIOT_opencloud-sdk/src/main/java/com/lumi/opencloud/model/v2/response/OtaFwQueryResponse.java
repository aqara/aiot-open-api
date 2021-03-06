package com.lumi.opencloud.model.v2.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/6/3 14:42
 * @description
 */
@Data
public class OtaFwQueryResponse {

    private String firmwareVersion;

    private String part;

    private Integer fileSize;

    private Integer necessary;

    private String updateLog;

    private String releaseTime;
}
