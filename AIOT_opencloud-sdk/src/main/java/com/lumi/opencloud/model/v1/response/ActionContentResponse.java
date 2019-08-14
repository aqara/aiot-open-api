package com.lumi.opencloud.model.v1.response;

import com.lumi.opencloud.model.ifttt.IftttParam;
import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 18:18
 * @description
 */
@Data
public class ActionContentResponse {

    private String actionId;

    private String actionName;

    private String did;

    /**
     * 对象模型
     */
    private String model;

    /**
     * 参数
     */
    private List<IftttParam> params;
}
