package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/10
 * @Description:
 */
@Data
public class EventMsgCommonBean implements Serializable{
    private String eventType;

    private String time;

    private Map<String, Object> data;
}
