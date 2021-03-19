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
}
