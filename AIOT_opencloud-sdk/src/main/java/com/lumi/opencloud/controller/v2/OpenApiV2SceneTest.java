package com.lumi.opencloud.controller.v2;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.SceneManager;
import com.lumi.opencloud.model.v2.request.SceneCreateRequest;
import com.lumi.opencloud.model.v2.request.SceneTryRequest;
import com.lumi.opencloud.model.v2.request.SceneUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvyl
 * @date 2019/7/16 18:06
 * @description
 */
@RestController
@RequestMapping(path = "/v2.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpenApiV2SceneTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV2SceneTest.class);

    @PostMapping("/ifttt/scene/create")
    public ResponseMsg createScene(@RequestBody SceneCreateRequest request) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.createScene(request);
        log.info("ifttt scene create responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ifttt/scene/update")
    public ResponseMsg updateScene(@RequestBody SceneUpdateRequest request) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.updateScene(request);
        log.info("ifttt scene update responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/scene/delete")
    public ResponseMsg deleteScene(@RequestParam String sceneId) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.deleteScene(sceneId);
        log.info("ifttt scene delete responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ifttt/scene/try")
    public ResponseMsg tryScene(@RequestBody SceneTryRequest request) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.tryScene(request);
        log.info("ifttt scene try responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/scene/run")
    public ResponseMsg runScene(@RequestParam String sceneId) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.runScene(sceneId);
        log.info("ifttt scene run responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/scene/query/detail")
    public ResponseMsg queryDetailScene(@RequestParam String sceneId) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.queryDetailScene(sceneId);
        log.info("ifttt scene query detail responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/scene/subject/query")
    public ResponseMsg querySubjectScene(@RequestParam String subjectId) {
        configClientV2();
        ResponseMsg responseMsg = SceneManager.querySubjectScene(subjectId);
        log.info("ifttt scene subject query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }
}
