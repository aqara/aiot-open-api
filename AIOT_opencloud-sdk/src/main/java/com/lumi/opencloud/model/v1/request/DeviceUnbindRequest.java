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
public class DeviceUnbindRequest extends BaseRequest {

    private static final long serialVersionUID = -8958535676045835822L;

    /**
     * 设备id
     */
    private String did;

    private Integer option;

    @Override
    public String uri() {
        return "/device/unbind";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did)){
            return false;
        }
        return super.paramValid();
    }
}
