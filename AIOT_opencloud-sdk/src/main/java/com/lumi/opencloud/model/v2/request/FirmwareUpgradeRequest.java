package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/6/3 11:51
 * @description
 */
@Data
public class FirmwareUpgradeRequest extends BaseRequest{
    private static final long serialVersionUID = -1408081271940100305L;
    private String did;

    private String firmwareVersion;

    @Override
    public String uri() {
        return "/ota/upgrade/firmware";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did)){
            return false;
        }
        if(StringUtils.isBlank(firmwareVersion)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        paramsMap.put("firmwareVersion",firmwareVersion);
        return paramsMap;
    }
}
