package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 19:14
 * @description
 */
@Data
public class SceneListQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 8073713192830662939L;

    private String positionId;

    private Integer pageNum;

    private Integer pageSize;

    @Override
    public String uri() {
        return "/scene/query";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(positionId)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("positionId",positionId);
        paramsMap.put("pageNum",pageNum);
        paramsMap.put("pageSize",pageSize);
        return paramsMap;
    }
}
