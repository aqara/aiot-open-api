package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class ResourceSubscribeInfo extends BaseRequest {

    private static final long serialVersionUID = 4868478563413652216L;

    private String did;

    private List<String> attrs;

    private String attach;

    @Override
    public String uri() {
        return null;
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did) || CollectionUtils.isEmpty(attrs)){
            return false;
        }
        return super.paramValid();
    }
}
