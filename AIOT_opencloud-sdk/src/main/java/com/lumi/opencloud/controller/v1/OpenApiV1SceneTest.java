package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.SceneManager;
import com.lumi.opencloud.model.v1.request.SceneCreateRequest;
import com.lumi.opencloud.model.v1.request.SceneListQueryRequest;
import com.lumi.opencloud.model.v1.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvyl
 * @date 2019/7/17 15:39
 * @description
 */
@RestController
@RequestMapping(path = "/v1.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpenApiV1SceneTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV1SceneTest.class);

    @GetMapping("/scene/query")
    public ResponseMsg queryScene(@RequestHeader String token, @RequestParam String positionId,
                                  @RequestParam(required = false,defaultValue = "1") int pageNum, @RequestParam(required = false,defaultValue = "50") int pageSize) {
        configClientV1(token);
        SceneListQueryRequest request = new SceneListQueryRequest();
        request.setPositionId(positionId);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        ResponseMsg<SceneListQueryResponse> responseMsg = SceneManager.querySceneList(request);
        log.info("scene query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/scene/query/detail")
    public ResponseMsg querySceneDetail(@RequestHeader String token, @RequestParam String sceneId) {
        configClientV1(token);
        ResponseMsg<SceneQueryDetailResponse> responseMsg = SceneManager.querySceneDetail(sceneId);
        log.info("scene query detail responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/scene/add")
    public ResponseMsg createScene(@RequestHeader String token, @RequestBody SceneCreateRequest request) {
        configClientV1(token);
        ResponseMsg<SceneCreateResponse> responseMsg = SceneManager.createScene(request);
        log.info("scene add responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/scene/delete")
    public ResponseMsg deleteScene(@RequestHeader String token, @RequestParam String sceneId) {
        configClientV1(token);
        ResponseMsg responseMsg = SceneManager.deleteScene(sceneId);
        log.info("scene delete responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/scene/run")
    public ResponseMsg runScene(@RequestHeader String token, @RequestParam String sceneId) {
        configClientV1(token);
        ResponseMsg responseMsg = SceneManager.runScene(sceneId);
        log.info("scene run responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

}
