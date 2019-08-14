package com.lumi.opencloud.controller.v2;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.PropertiesManager;
import com.lumi.opencloud.model.v2.request.PropertiesQueryInfo;
import com.lumi.opencloud.model.v2.request.PropertiesWriteRequest;
import com.lumi.opencloud.model.v2.request.ResourceHistoryQueryRequest;
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
public class OpenApiV2PropertiesTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV2PropertiesTest.class);

    @PostMapping("/properties/query")
    public ResponseMsg propertiesQuery(@RequestBody List<PropertiesQueryInfo> queryList) {
        configClientV2();
        ResponseMsg responseMsg = PropertiesManager.query(queryList);
        log.info("properties query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/properties/write")
    public ResponseMsg propertiesWrite(@RequestBody PropertiesWriteRequest request) {
        configClientV2();
        ResponseMsg responseMsg = PropertiesManager.write(request);
        log.info("properties write responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/properties/history/query")
    public ResponseMsg propertiesHistoryQuery(@RequestBody ResourceHistoryQueryRequest request) {
        configClientV2();
        ResponseMsg responseMsg = PropertiesManager.historyQuery(request);
        log.info("properties history query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }
}
