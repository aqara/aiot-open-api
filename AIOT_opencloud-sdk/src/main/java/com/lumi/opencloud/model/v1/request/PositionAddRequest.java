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
public class PositionAddRequest extends BaseRequest {
    private static final long serialVersionUID = -3583407940035634498L;

    /**
     * 位置名称
     */
    private String positionName;

    /**
     * 父位置id
     */
    private String parentPositionId;

    /**
     * 	位置描述
     */
    private String description;

    @Override
    public String uri() {
        return "/position/add";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(positionName)){
            return false;
        }
        return super.paramValid();
    }
}
