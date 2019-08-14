package com.lumi.opencloud.model.v1.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lvyl
 * @date 2019/7/19 15:25
 * @description 事件消息
 */
@Data
public class EventMessageBean implements Serializable {

    private static final long serialVersionUID = -8545489972390195654L;

    private String did;

    private String name;

    private String model;

    private String parentId;

    private String event;

    private String openId;

    private String time;
}
