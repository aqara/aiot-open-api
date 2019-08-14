package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


/**
 * @author lvyl
 * @date 2019/7/15 19:29
 * @description
 */
@Data
public class IftttEnableRequest extends BaseRequest {

    /**
     * 联动id
     */
    private String iftttId;

    /**
     * 	0-open，1-close
     */
    private Integer enable;

    @Override
    public String uri() {
        return "/ifttt/enable";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(iftttId)){
            return false;
        }
        return super.paramValid();
    }
}
