package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class DeviceBindGetRequest extends BaseRequest{

    private static final long serialVersionUID = -3242864072773759727L;

    @Override
    public String uri() {
        return "/dev/bind/get";
    }

}
