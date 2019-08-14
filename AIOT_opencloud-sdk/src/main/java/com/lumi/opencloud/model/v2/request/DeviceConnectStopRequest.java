package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class DeviceConnectStopRequest extends BaseRequest {

    private static final long serialVersionUID = 8553185897385479077L;

    /**
     * 网关id
     */
    private String did;

    @Override
    public String uri() {
        return "/dev/connect/subdevice/stop";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap(){
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("did",did);
        return paramsMap;
    }
}
