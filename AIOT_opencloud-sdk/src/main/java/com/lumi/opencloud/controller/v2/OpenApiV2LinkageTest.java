package com.lumi.opencloud.controller.v2;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.LinkageManager;
import com.lumi.opencloud.model.v2.request.IftttCreateRequest;
import com.lumi.opencloud.model.v2.request.IftttUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/16 18:06
 * @description
 */
@RestController
@RequestMapping(path = "/v2.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpenApiV2LinkageTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV2LinkageTest.class);

    @GetMapping("/ifttt/trigger/definition/query")
    public ResponseMsg triggerDefinitionQuery(@RequestParam List<String> models) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.triggerDefinitionQuery(models);
        log.info("ifttt trigger definition query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/action/definition/query")
    public ResponseMsg actionDefinitionQuery(@RequestParam List<String> models) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.actionDefinitionQuery(models);
        log.info("ifttt action definition query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ifttt/create")
    public ResponseMsg createIfttt(@RequestBody IftttCreateRequest request) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.createIfttt(request);
        log.info("ifttt create responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ifttt/update")
    public ResponseMsg updateIfttt(@RequestBody IftttUpdateRequest request) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.updateIfttt(request);
        log.info("ifttt update responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/delete")
    public ResponseMsg deleteIfttt(@RequestParam String linkageId) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.deleteIfttt(linkageId);
        log.info("ifttt delete responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/state/update")
    public ResponseMsg enableIfttt(@RequestParam String linkageId,@RequestParam int state) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.enableIfttt(linkageId,state);
        log.info("ifttt enable responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/ifttt/query/linkage/detail")
    public ResponseMsg queryDetail(@RequestParam String linkageId) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.queryDetail(linkageId);
        log.info("ifttt query detail responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/ifttt/subject/query")
    public ResponseMsg subjectQuery(@RequestParam String subjectId) {
        configClientV2();
        ResponseMsg responseMsg = LinkageManager.subjectQuery(subjectId);
        log.info("ifttt subject query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }
}
