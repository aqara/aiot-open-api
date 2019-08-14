package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/15 15:13
 * @description
 */
@Data
public class PositionQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -2145074997806840187L;
    /**
     * 设备位置
     */
    private String positionId;

    /**
     * 分页页码
     */
    private Integer pageNum;

    /**
     * 分页大小
     */
    private Integer pageSize;

    @Override
    public String uri() {
        return "/position/query";
    }

    @Override
    public boolean paramValid() {
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
