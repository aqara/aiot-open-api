package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 19:29
 * @description
 */
@Data
public class IftttDeleteRequest extends BaseRequest {

    /**
     * 联动id
     */
    private String iftttId;

    @Override
    public String uri() {
        return "/ifttt/delete";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(iftttId)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap(){
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("iftttId",iftttId);
        return paramsMap;
    }
}
