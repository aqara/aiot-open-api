package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 18:11
 * @description
 */
@Data
public class DeviceQueryRequest extends BaseRequest {

    private List<String> dids;

    @Override
    public String uri() {
        return "/dev/query/detail";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(dids)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("dids", StringUtils.join(dids.toArray(),","));
        return paramsMap;
    }

}
