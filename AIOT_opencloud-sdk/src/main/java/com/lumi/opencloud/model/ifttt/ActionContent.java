package com.lumi.opencloud.model.ifttt;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 执行器内存
 * @author huangzhen
 * @date 2019/6/3
 */
@Data
public class ActionContent implements Serializable {

    private String actionDefinitionId;

    private String actionName;

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
