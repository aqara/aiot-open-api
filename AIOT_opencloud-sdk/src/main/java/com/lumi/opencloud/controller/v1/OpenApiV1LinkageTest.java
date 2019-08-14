package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.LinkageManager;
import com.lumi.opencloud.model.v1.request.IftttCreateRequest;
import com.lumi.opencloud.model.v1.request.IftttListQueryRequest;
import com.lumi.opencloud.model.v1.response.*;
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
public class OpenApiV1LinkageTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV1LinkageTest.class);

    @GetMapping("/ifttt/trigger/query")
    public ResponseMsg triggerQuery(@RequestHeader String token, @RequestParam List<String> models) {
        configClientV1(token);
        ResponseMsg<List<IftttTriggerQueryResponse>> responseMsg = LinkageManager.triggerQuery(models);
        log.info("trigger query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/action/query")
    public ResponseMsg actionQuery(@RequestHeader String token, @RequestParam List<String> models) {
        configClientV1(token);
        ResponseMsg<List<IftttActionQueryResponse>> responseMsg = LinkageManager.actionQuery(models);
        log.info("trigger query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/query")
    public ResponseMsg queryIfttt(@RequestHeader String token, @RequestParam(required = false) String positionId,
                                  @RequestParam(required = false,defaultValue = "1") int pageNum,@RequestParam(required = false,defaultValue = "50") int pageSize) {
        configClientV1(token);
        IftttListQueryRequest request = new IftttListQueryRequest();
        request.setPositionId(positionId);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        ResponseMsg<IftttListQueryResponse> responseMsg = LinkageManager.queryIfttt(request);
        log.info("trigger query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/query/detail")
    public ResponseMsg queryIftttDetail(@RequestHeader String token, @RequestParam String iftttId) {
        configClientV1(token);
        ResponseMsg<IftttDetailQueryResponse> responseMsg = LinkageManager.queryIftttDetail(iftttId);
        log.info("ifttt query detail responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @PostMapping("/ifttt/add")
    public ResponseMsg createIfttt(@RequestHeader String token, @RequestBody IftttCreateRequest request) {
        configClientV1(token);
        ResponseMsg<IftttListQueryResponse> responseMsg = LinkageManager.createIfttt(request);
        log.info("ifttt add responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/delete")
    public ResponseMsg deleteIfttt(@RequestHeader String token, @RequestParam String iftttId) {
        configClientV1(token);
        ResponseMsg responseMsg = LinkageManager.deleteIfttt(iftttId);
        log.info("ifttt delete responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/enable")
    public ResponseMsg enableIfttt(@RequestHeader String token, @RequestParam String iftttId,@RequestParam int enable) {
        configClientV1(token);
        ResponseMsg responseMsg = LinkageManager.enableIfttt(iftttId,enable);
        log.info("ifttt enable responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

}
