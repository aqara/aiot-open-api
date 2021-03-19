package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.model.ifttt.IftttParam;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 18:20
 * @description
 */
@Data
public class ActionContentRequest {

    private String did = "";

    private String subjectModel;

    @NotEmpty(message = "action不能为空")
    private String action;

    /**
     * 条件延时单位(0-毫秒/1-秒/2-分钟/3-小时/4-天)
     */
    private String delayTimeUnit;

    private String delayTime;

    /**
     * 参数
     */
    private List<IftttParam> params;
}
