package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lvyl
 * @date 2019/7/15 15:13
 * @description
 */
@Data
public class PositionDeleteRequest extends BaseRequest {
    private static final long serialVersionUID = -3583407940035634498L;

    /**
     * 位置id
     */
    private String positionId;

    @Override
    public String uri() {
        return "/position/delete";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(positionId)){
            return false;
        }
        return super.paramValid();
    }
}
