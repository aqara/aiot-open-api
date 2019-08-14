package com.lumi.opencloud.model.v2.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/6/3 14:42
 * @description
 */
@Data
public class OtaUpgradeQueryResponse {

    private String did;

    private int code;

    private int progress;
}
