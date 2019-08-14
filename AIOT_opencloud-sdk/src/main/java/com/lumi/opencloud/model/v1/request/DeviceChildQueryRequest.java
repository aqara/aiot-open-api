package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 16:03
 * @description
 */
@Data
public class DeviceChildQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -8958535676045835822L;

    /**
     * 设备id
     */
    private String did;

    @Override
    public String uri() {
        return "/device/child/query";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        return paramsMap;
    }
}
