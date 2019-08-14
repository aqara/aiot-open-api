package com.lumi.opencloud.model.v2.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @Author: zzm
 * @Date: 2019/06/04
 * @Description:
 */
@Data
public class MessageHistoryQueryRequest {

    public static final int SIZE_MAX = 300;
    public static final int SIZE_MIN = 10;
    public static final int SIZE_DEFAULT = 100;

    private Set<String> dids;

    @NotBlank(message = "type not empty")
    private String type;

    private String startTime;

    private String endTime;

    @Max(value = SIZE_MAX, message = "当前页最大不能超过300")
    @Min(value = SIZE_MIN, message = "当前页不能少于10")
    private Integer size = SIZE_DEFAULT;
}
