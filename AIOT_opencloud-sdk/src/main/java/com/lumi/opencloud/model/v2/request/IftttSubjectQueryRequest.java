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
public class IftttSubjectQueryRequest extends BaseRequest {

    private String subjectId;

    @Override
    public String uri() {
        return "/ifttt/subject/query";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(subjectId)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("subjectId",subjectId);
        return paramsMap;
    }
}
