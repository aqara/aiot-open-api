package com.lumi.opencloud.model.v1.response;

import lombok.Data;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 15:28
 * @description
 */
@Data
public class SceneQueryDetailResponse {

    private String sceneId;

    private String name;

    private List<ActionContentResponse> content;

    private String createTime;
}
