package com.lumi.opencloud.model.v2.request;

import lombok.Data;

/**
 * @Author: zzm
 * @Date: 2019/06/04
 * @Description:
 */
@Data
public class ResourceHistoryQueryRequest extends PropertiesQueryInfo {
    public static final int SIZE_MAX = 300;
    public static final int SIZE_MIN = 10;
    public static final int SIZE_DEFAULT = 100;

    private String startTime;

    private String endTime;

    private Integer size = SIZE_DEFAULT;

    @Override
    public String uri() {
        return "/properties/history/query";
    }

    @Override
    public boolean paramValid() {
        if(size > SIZE_MAX || size < SIZE_MIN){
            return false;
        }
        return super.paramValid();
    }
}
