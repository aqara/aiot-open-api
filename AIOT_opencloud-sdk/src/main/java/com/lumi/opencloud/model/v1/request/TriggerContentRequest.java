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
public class TriggerContentRequest {

    private String did = "";

    /**
     * 0716新增
     */
    private String subjectModel;

    @NotEmpty(message = "trigger不能为空")
    private String trigger;

    // 自动化时段 开始时间正则表达式 0 23 * * 5,6,0
    private String beginTime;

    // 自动化时段 结束时间正则表达式 0 23 * * 5,6,0
    private String endTime;

    /**
     * 参数
     */
    private List<IftttParam> params;
}
