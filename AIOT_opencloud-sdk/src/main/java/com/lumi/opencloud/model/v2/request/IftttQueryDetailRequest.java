package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 20:21
 * @description
 */
@Data
public class IftttQueryDetailRequest extends BaseRequest {

    private String linkageId;

    @Override
    public String uri() {
        return "/ifttt/query/linkage/detail";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(linkageId)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("linkageId",linkageId);
        return paramsMap;
    }
}
