package com.lumi.opencloud.model.v1.message;

import lombok.Data;
import java.io.Serializable;

/**
 * @author lvyl
 * @date 2019/7/19 15:25
 * @description 资源消息
 */
@Data
public class ResourceMessageBean implements Serializable {

    private static final long serialVersionUID = 8242253225889396831L;

    private String did;

    private String model;

    private String openId;

    private String attr;

    private String value;

    private String attach;

    private String time;
}
