package com.lumi.opencloud.model.v2.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/17 12:17
 * @description
 */
@Data
public class SceneSubjectQueryResponse {

    private String sceneId;

    private Long createTime;

    private Long updateTime;

    private Integer localize;

}
