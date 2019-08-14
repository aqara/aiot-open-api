package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/16 15:57
 * @description
 */
@Data
public class OtaFirmwareUpgradeRequest extends BaseRequest {

    private static final long serialVersionUID = 2588917936004995701L;

    /**
     * Device list (Maximum list :100)
     */
    private List<OtaFirmwareUpgradeDetail> data;

    @Override
    public String uri() {
        return "/ota/upgrade/firmware";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(data)){
            return false;
        }
        return super.paramValid();
    }
}
