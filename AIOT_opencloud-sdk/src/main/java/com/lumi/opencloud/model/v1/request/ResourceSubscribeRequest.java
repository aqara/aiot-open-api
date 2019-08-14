package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import java.util.List;

/**
 * @Author: lumi
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class ResourceSubscribeRequest extends BaseRequest {

    private static final long serialVersionUID = -562054003261052371L;

    private List<ResourceSubscribeInfo> data;

    @Override
    public String uri() {
        return "/subscriber/resource";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(data)){
            return false;
        }
        return super.paramValid();
    }
}
