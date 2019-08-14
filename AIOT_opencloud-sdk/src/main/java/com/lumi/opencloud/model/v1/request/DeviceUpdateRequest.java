package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvyl
 * @date 2019/7/15 16:03
 * @description
 */
@Data
public class DeviceUpdateRequest extends BaseRequest {

    private static final long serialVersionUID = -8958535676045835822L;

    /**
     * 设备id
     */
    private String did;

    /**
     * 设备名称
     */
    private String name;

    @Override
    public String uri() {
        return "/device/update";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did) || StringUtils.isBlank(name) ){
            return false;
        }
        return super.paramValid();
    }
}
