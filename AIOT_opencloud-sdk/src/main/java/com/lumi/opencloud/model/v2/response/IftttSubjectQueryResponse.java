package com.lumi.opencloud.model.v2.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/17 12:17
 * @description
 */
@Data
public class IftttSubjectQueryResponse {

    /**
     * 自动化ID
     */
    private String linkageId;

    private Long createTime;

    private Long updateTime;

    private Integer state;

    private Integer localize;


}
