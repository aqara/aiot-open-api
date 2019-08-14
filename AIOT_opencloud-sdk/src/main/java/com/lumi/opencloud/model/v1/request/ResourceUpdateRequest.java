package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class ResourceUpdateRequest extends BaseRequest {

    private static final long serialVersionUID = -562054003261052371L;

    private String did;

    private Map<String,Object> attrs;

    @Override
    public String uri() {
        return "/resource/update";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did) || attrs.isEmpty()){
            return false;
        }
        return super.paramValid();
    }
}
