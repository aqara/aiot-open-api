package com.lumi.opencloud.model.ifttt;

import lombok.Data;

import java.io.Serializable;

/**
 * 自动化参数
 * @author huangzhen
 * @date 2019/6/3
 */
@Data
public class IftttParam implements Serializable {

    private String paramId;

    private String paramName;

    private String value;

    private String paramType;

    private String paramUnit;

    private String paramEnum;

    private String defaultValue;

    private String minValue;

    private String maxValue;
}
