package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lumi
 */
@Data
public class DeviceTimezoneUpdateRequest extends BaseRequest {

    private static final long serialVersionUID = -2674246384138625799L;

    /**
     * 设备id
     */
    private List<String> dids;

    /**
     * 时区
     */
    private String timeZone;

    @Override
    public String uri() {
        return "/dev/timezone/update";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(dids) || StringUtils.isBlank(timeZone)){
            return false;
        }
        return super.paramValid();
    }

}
