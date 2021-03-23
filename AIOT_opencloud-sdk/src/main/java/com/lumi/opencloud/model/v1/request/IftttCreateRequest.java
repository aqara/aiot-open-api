package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/15 19:29
 * @description
 */
public class IftttCreateRequest extends BaseRequest {

    /**
     * 联动名称
     */
    private String name;

    /**
     * 位置id
     */
    private String positionId;

    /**
     * 条件与（0）或（1），默认与（0）
     */
    private Integer conditionRelation;
    /**
     * 触发器
     */
    private List<TriggerContentRequest> conditions;
    /**
     * 执行器
     */
    private List<ActionContentRequest> actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Integer getConditionRelation() {
        return conditionRelation;
    }

    public void setConditionRelation(Integer conditionRelation) {
        this.conditionRelation = conditionRelation;
    }

    public List<TriggerContentRequest> getConditions() {
        return conditions;
    }

    public void setConditions(List<TriggerContentRequest> conditions) {
        this.conditions = conditions;
    }

    public List<ActionContentRequest> getActions() {
        return actions;
    }

    public void setActions(List<ActionContentRequest> actions) {
        this.actions = actions;
    }

    @Override
    public String uri() {
        return "/ifttt/add";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(name) || StringUtils.isBlank(positionId)
                ||CollectionUtils.isEmpty(conditions)|| CollectionUtils.isEmpty(actions)){
            return false;
        }
        return super.paramValid();
    }
}
