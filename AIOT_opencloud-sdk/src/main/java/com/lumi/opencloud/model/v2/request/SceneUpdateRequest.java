package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import com.lumi.opencloud.model.ifttt.ActionContent;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/16 9:24
 * @description
 */
@Data
public class SceneUpdateRequest extends BaseRequest{

    private String sceneId;

    private List<ActionContent> actions;

    @Override
    public String uri() {
        return "/ifttt/scene/update";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(actions) || StringUtils.isBlank(sceneId)){
            return false;
        }
        return super.paramValid();
    }
}
