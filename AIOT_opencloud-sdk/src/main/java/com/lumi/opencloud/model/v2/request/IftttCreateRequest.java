package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import com.lumi.opencloud.model.ifttt.*;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/15 19:29
 * @description
 */
@Data
public class IftttCreateRequest extends BaseRequest {

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
        return "/ifttt/create";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(conditions)|| CollectionUtils.isEmpty(actions)){
            return false;
        }
        return super.paramValid();
    }
}
