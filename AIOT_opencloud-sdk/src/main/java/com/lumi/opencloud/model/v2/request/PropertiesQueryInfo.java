package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class PropertiesQueryInfo extends BaseRequest{

    private static final long serialVersionUID = 4868478563413652216L;

    private String did;

    private List<String> properties;

    @Override
    public String uri() {
        return null;
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did)){
            return false;
        }
        return super.paramValid();
    }
}
