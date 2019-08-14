package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 19:14
 * @description
 */
@Data
public class IftttTriggerQueryRequest extends BaseRequest {
    private static final long serialVersionUID = -3723987760960362925L;

    private List<String> models;

    @Override
    public String uri() {
        return "/ifttt/trigger/query";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(models)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("models", StringUtils.join(models.toArray(),","));
        return paramsMap;
    }
}
