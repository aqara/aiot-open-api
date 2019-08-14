package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.ResourceManager;
import com.lumi.opencloud.model.v1.request.ResourceHistoryQueryRequest;
import com.lumi.opencloud.model.v1.request.ResourceQueryInfo;
import com.lumi.opencloud.model.v1.request.ResourceSubscribeInfo;
import com.lumi.opencloud.model.v1.request.ResourceUpdateRequest;
import com.lumi.opencloud.model.v1.response.ResourceHistoryQueryResponse;
import com.lumi.opencloud.model.v1.response.ResourceQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 15:39
 * @description
 */
@RestController
@RequestMapping(path = "/v1.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpenApiV1ResourceTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV1ResourceTest.class);

    @PostMapping("/resource/query")
    public ResponseMsg resourceQuery(@RequestHeader String token, @RequestBody List<ResourceQueryInfo> infoList) {
        configClientV1(token);
        ResponseMsg<List<ResourceQueryResponse>> responseMsg = ResourceManager.query(infoList);
        log.info("resource query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/resource/update")
    public ResponseMsg resourceUpdate(@RequestHeader String token, @RequestBody ResourceUpdateRequest request) {
        configClientV1(token);
        ResponseMsg responseMsg = ResourceManager.update(request);
        log.info("resource update responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/subscriber/resource")
    public ResponseMsg resourceSubscriber(@RequestHeader String token, @RequestBody List<ResourceSubscribeInfo> infoList) {
        configClientV1(token);
        ResponseMsg responseMsg = ResourceManager.subscriber(infoList);
        log.info("resource subscriber responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/unsubscriber/resource")
    public ResponseMsg resourceUnSubscriber(@RequestHeader String token, @RequestBody List<ResourceSubscribeInfo> infoList) {
        configClientV1(token);
        ResponseMsg responseMsg = ResourceManager.unsubscriber(infoList);
        log.info("resource unsubscriber responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/resource/history/query")
    public ResponseMsg resourceHistoryQuery(@RequestHeader String token, @RequestBody ResourceHistoryQueryRequest request) {
        configClientV1(token);
        ResponseMsg<ResourceHistoryQueryResponse> responseMsg = ResourceManager.historyQuery(request);
        log.info("resource history query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

}
