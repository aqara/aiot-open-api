package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/15 19:14
 * @description
 */
@Data
public class SceneCreateRequest extends BaseRequest {

    private static final long serialVersionUID = -3864014510254495812L;

    private String name;

    private String positionId;

    private List<ActionContentRequest> content;

    @Override
    public String uri() {
        return "/scene/add";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(name) || StringUtils.isBlank(positionId) || CollectionUtils.isEmpty(content)){
            return false;
        }
        return super.paramValid();
    }
}
