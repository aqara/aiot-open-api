package com.lumi.opencloud.model.v1.response;

import com.lumi.opencloud.model.ifttt.IftttParam;
import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 11:25
 * @description
 */
@Data
public class IftttActionQueryResponse {

    private String actionDefinitionId;

    private String model;

    private String actionName;

    private List<IftttParam> params;
}
