package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.model.ifttt.IftttParam;
import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 18:20
 * @description
 */
@Data
public class ActionContentRequest {

    private String action;

    private String did;

    /**
     * 参数
     */
    private List<IftttParam> params;
}
