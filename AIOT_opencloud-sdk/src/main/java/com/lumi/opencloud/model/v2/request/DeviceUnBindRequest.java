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
public class DeviceUnBindRequest extends BaseRequest {

    private static final long serialVersionUID = -2612187410767816761L;
    /**
     * 设备id
     */
    private String did;

    /**
     * 绑定查询
     * 0-解绑(默认)
     * 1-解绑+清除自动化信息
     */
    private Integer options = 0;

    @Override
    public String uri() {
        return "/dev/unbind";
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
        paramsMap.put("options",options);
        return paramsMap;
    }
}
