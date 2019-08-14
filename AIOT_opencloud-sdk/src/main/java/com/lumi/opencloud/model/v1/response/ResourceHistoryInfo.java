package com.lumi.opencloud.model.v1.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/17 17:42
 * @description
 */
@Data
public class ResourceHistoryInfo {

    private String did;

    private String attr;

    private String value;

    private String timeStamp;
}
