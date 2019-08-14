package com.lumi.opencloud.model.v2.response;

import com.lumi.opencloud.model.ifttt.ActionContent;
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

    private List<ActionContent> actions;

    private String createTime;

    private String updateTime;
}
