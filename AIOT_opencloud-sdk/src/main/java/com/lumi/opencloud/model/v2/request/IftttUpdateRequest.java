package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import com.lumi.opencloud.model.ifttt.ActionContent;
import com.lumi.opencloud.model.ifttt.TriggerContent;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 20:14
 * @description
 */
@Data
public class IftttUpdateRequest extends BaseRequest {

    private String linkageId;

    /**
     * 条件与（0）或（1），默认与（0）
     */
    private Integer relation;
    /**
     * 触发器
     */
    private List<TriggerContent> conditions;
    /**
     * 执行器
     */
    private List<ActionContent> actions;

    @Override
    public String uri() {
        return "/ifttt/update";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(linkageId) || CollectionUtils.isEmpty(conditions)|| CollectionUtils.isEmpty(actions)){
            return false;
        }
        return super.paramValid();
    }

}
