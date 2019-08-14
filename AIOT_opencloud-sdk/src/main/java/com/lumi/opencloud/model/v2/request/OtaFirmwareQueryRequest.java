package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/16 15:57
 * @description
 */
@Data
public class OtaFirmwareQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 2588917936004995701L;

    private String model;

    @Override
    public String uri() {
        return "/ota/firmware/query";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(model)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("model",model);
        return paramsMap;
    }
}
