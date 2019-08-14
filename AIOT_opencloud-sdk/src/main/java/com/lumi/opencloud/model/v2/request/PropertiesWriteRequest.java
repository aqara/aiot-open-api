package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/01
 * @Description:
 */
@Data
public class PropertiesWriteRequest extends BaseRequest{

    private static final long serialVersionUID = 7041074584167409773L;
    /**
     * 写资源
     */
    private Map<String /*property*/, Object /*value*/> data;

    /**
     * 设备id
     */
    private String did;

    @Override
    public String uri() {
        return "/properties/write";
    }

    @Override
    public boolean paramValid(){
        if(null == data || data.isEmpty()){
            return false;
        }
        if(StringUtils.isBlank(did)){
            return false;
        }
        return super.paramValid();
    }
}
