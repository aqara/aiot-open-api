package com.lumi.opencloud.model.v2.message;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description: 本地化结果通知
 */
@Data
public class IftttMsgEventBean implements Serializable {

    private static final long serialVersionUID = 4140488873748437477L;

    private List<String> iftttIds;
}
