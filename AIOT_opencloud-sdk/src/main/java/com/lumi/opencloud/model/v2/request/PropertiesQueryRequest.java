package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class PropertiesQueryRequest extends BaseRequest{

    private static final long serialVersionUID = -8906176864001321275L;

    private List<PropertiesQueryInfo> data;

    @Override
    public String uri() {
        return "/properties/query";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(data)){
            return false;
        }
        for(PropertiesQueryInfo item : data){
            if(!item.paramValid()){
                return false;
            }
        }

        return super.paramValid();
    }
}
