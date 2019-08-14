package com.lumi.opencloud.model.ifttt;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 触发对象
 * @author lumi
 * @date 2019/6/3
 */
@Data
public class TriggerContent implements Serializable {

    private static final long serialVersionUID = 8421983413945950168L;

    private String triggerDefinitionId;

    private String triggerName;

    /**
     * 对象ID
     */
    private String subjectId;

    /**
     * 对象模型
     */
    private String model;

    /**
     * 参数
     */
    private List<IftttParam> params;
}
