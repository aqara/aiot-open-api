package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/16 9:24
 * @description
 */
@Data
public class SceneDeleteRequest extends BaseRequest{

    private String sceneId;

    @Override
    public String uri() {
        return "/ifttt/scene/delete";
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
