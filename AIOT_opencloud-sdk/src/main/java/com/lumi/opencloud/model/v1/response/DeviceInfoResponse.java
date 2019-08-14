package com.lumi.opencloud.model.v1.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/17 15:57
 * @description
 */
@Data
public class DeviceInfoResponse {

    private String did;

    private String name;

    private String model;

    private String parentId;

    private int state;

    private String registerTime;
}
