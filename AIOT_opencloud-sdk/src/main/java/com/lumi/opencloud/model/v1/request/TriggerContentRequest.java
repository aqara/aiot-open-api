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

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getSubjectModel() {
        return subjectModel;
    }

    public void setSubjectModel(String subjectModel) {
        this.subjectModel = subjectModel;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<IftttParam> getParams() {
        return params;
    }

    public void setParams(List<IftttParam> params) {
        this.params = params;
    }
}
