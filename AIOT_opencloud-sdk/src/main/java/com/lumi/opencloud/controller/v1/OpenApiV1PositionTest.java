package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.PositionManager;
import com.lumi.opencloud.model.v1.request.PositionQueryRequest;
import com.lumi.opencloud.model.v1.response.PositionQueryResponse;
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
public class OpenApiV1PositionTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV1PositionTest.class);

    @GetMapping("/position/query")
    public ResponseMsg positionQuery(@RequestHeader String token, @RequestParam(required = false) String positionId,
                                     @RequestParam(required = false,defaultValue = "1") int pageNum,@RequestParam(required = false,defaultValue = "50") int pageSize) {
        configClientV1(token);
        PositionQueryRequest request = new PositionQueryRequest();
        request.setPositionId(positionId);
        request.setPageNum(pageNum);
        request.setPageSize(pageSize);
        ResponseMsg<PositionQueryResponse> responseMsg = PositionManager.positionQuery(request);
        log.info("device query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/position/add")
    public ResponseMsg positionAdd(@RequestHeader String token, @RequestParam String positionName,
                                   @RequestParam(required = false) String parentPositionId,@RequestParam(required = false) String description) {
        configClientV1(token);
        ResponseMsg responseMsg = PositionManager.positionAdd(positionName,parentPositionId,description);
        log.info("position add responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/position/delete")
    public ResponseMsg positionDelete(@RequestHeader String token, @RequestParam String positionId) {
        configClientV1(token);
        ResponseMsg responseMsg = PositionManager.positionDelete(positionId);
        log.info("position delete responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/position/update")
    public ResponseMsg positionUpdate(@RequestHeader String token, @RequestParam String positionId,@RequestParam String positionName,
                                      @RequestParam(required = false) String description) {
        configClientV1(token);
        ResponseMsg responseMsg = PositionManager.positionUpdate(positionId,positionName,description);
        log.info("position update responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

}
