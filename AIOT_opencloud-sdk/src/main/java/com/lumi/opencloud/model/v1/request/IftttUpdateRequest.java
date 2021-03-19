package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/8 12:22 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class IftttUpdateRequest extends BaseRequest {
    private String userId;

    @NotEmpty(message = "linkageId can not be empty")
    private String linkageId;

    private String name;

    private String positionId;

    private int conditionRelation = 1;

    private List<TriggerContentRequest> conditions;

    private List<ActionContentRequest> actions;

    private int state = 1;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLinkageId() {
        return linkageId;
    }

    public void setLinkageId(String linkageId) {
        this.linkageId = linkageId;
    }

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

    public int getConditionRelation() {
        return conditionRelation;
    }

    public void setConditionRelation(int conditionRelation) {
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String uri() {
        return null;
    }
}