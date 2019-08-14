package com.lumi.opencloud.model.v2.request;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/16 15:57
 * @description
 */
@Data
public class OtaFirmwareUpgradeDetail {

    /**
     * Device id (Maximum list :100)
     */
    private String did;

    /**
     * Firmware version to be upgraded
     */
    private String firmwareVersion;
}
