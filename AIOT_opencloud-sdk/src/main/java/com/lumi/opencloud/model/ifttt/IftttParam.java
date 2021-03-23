package com.lumi.opencloud.model.ifttt;

import java.io.Serializable;

/**
 * 自动化参数
 * @author huangzhen
 * @date 2019/6/3
 */
public class IftttParam implements Serializable {

    /**
     * 参数值
     */
    private String value;
    /**
     * 参数定义ID
     */
    private String paramId;
    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 单位
     */
    private String paramUnit;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamUnit() {
        return paramUnit;
    }

    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit;
    }
}
