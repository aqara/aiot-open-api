package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.DeviceManager;
import com.lumi.opencloud.model.v1.request.DeviceQueryRequest;
import com.lumi.opencloud.model.v1.request.DeviceUpdateRequest;
import com.lumi.opencloud.model.v1.response.DeviceQueryResponse;
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
public class OpenApiV1DeviceTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV1DeviceTest.class);

    @PostMapping("/device/query")
    public ResponseMsg deviceQuery(@RequestHeader String token,@RequestBody DeviceQueryRequest request) {
        configClientV1(token);
        ResponseMsg<DeviceQueryResponse> responseMsg = DeviceManager.deviceQuery(request);
        log.info("device query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/device/update")
    public ResponseMsg deviceUpdate(@RequestHeader String token,@RequestParam String did,@RequestParam String name) {
        configClientV1(token);
        ResponseMsg responseMsg = DeviceManager.deviceUpdate(did,name);
        log.info("device update responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/device/connect")
    public ResponseMsg deviceConnect(@RequestHeader String token,@RequestParam String did) {
        configClientV1(token);
        ResponseMsg responseMsg = DeviceManager.deviceConnect(did);
        log.info("device connect responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/device/connect/stop")
    public ResponseMsg deviceConnectStop(@RequestHeader String token,@RequestParam String did) {
        configClientV1(token);
        ResponseMsg responseMsg = DeviceManager.deviceConnectStop(did);
        log.info("device connect stop responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/device/child/query")
    public ResponseMsg childQuery(@RequestHeader String token, @RequestParam String did) {
        configClientV1(token);
        ResponseMsg responseMsg = DeviceManager.childQuery(did);
        log.info("device child query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/device/unbind")
    public ResponseMsg unbindDev(@RequestHeader String token, @RequestParam String did) {
        configClientV1(token);
        ResponseMsg responseMsg = DeviceManager.unbindDev(did,1);
        log.info("device unbind responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

}
