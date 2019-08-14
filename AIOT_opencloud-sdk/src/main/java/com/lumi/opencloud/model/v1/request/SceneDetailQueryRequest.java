package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 19:14
 * @description
 */
@Data
public class SceneDetailQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -3864014510254495812L;

    private String sceneId;

    @Override
    public String uri() {
        return "/scene/query/detail";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(sceneId)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("sceneId",sceneId);
        return paramsMap;
    }
}
