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
public class DeviceQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -4503240000908932600L;

    /**
     * 设备位置
     */
    private String positionId;

    /**
     * 设备ID
     */
    private String did;

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
        return "/device/query";
    }

    @Override
    public boolean paramValid() {
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("positionId",positionId);
        paramsMap.put("did",did);
        paramsMap.put("pageNum",pageNum);
        paramsMap.put("pageSize",pageSize);
        return paramsMap;
    }
}
