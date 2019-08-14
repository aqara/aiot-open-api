package com.lumi.opencloud.model.v2.response;

import com.lumi.opencloud.model.ifttt.ActionContent;
import com.lumi.opencloud.model.ifttt.TriggerContent;
import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 12:17
 * @description
 */
@Data
public class IftttLinkageDetailResponse {

    /**
     * 自动化ID
     */
    private String linkageId;

    /**
     * 条件与（0）或（1），默认与（0）
     */
    private Integer relation;

    private Long createTime;

    private Long updateTime;

    private Integer state;

    private Integer localize;

    /**
     * 触发器
     */
    private List<TriggerContent> conditions;

    /**
     * 执行器
     */
    private List<ActionContent> actions;


}
