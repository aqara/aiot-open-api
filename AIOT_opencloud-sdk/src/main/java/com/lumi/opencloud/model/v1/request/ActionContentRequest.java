package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.model.ifttt.IftttParam;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 18:20
 * @description
 */

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDelayTimeUnit() {
        return delayTimeUnit;
    }

    public void setDelayTimeUnit(String delayTimeUnit) {
        this.delayTimeUnit = delayTimeUnit;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public List<IftttParam> getParams() {
        return params;
    }

    public void setParams(List<IftttParam> params) {
        this.params = params;
    }
}
