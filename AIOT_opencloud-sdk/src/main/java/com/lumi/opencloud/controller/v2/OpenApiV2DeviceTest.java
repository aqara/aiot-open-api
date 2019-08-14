package com.lumi.opencloud.controller.v2;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.DeviceManager;
import com.lumi.opencloud.model.v2.response.DeviceBindQueryResponse;
import com.lumi.opencloud.model.v2.response.DeviceInfoResponse;
import com.lumi.opencloud.model.v2.response.DeviceQueryDetailResponse;
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
public class OpenApiV2DeviceTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV2DeviceTest.class);

    @GetMapping("/dev/bind/get")
    public ResponseMsg bindGetTest() {
        configClientV2();
        ResponseMsg responseMsg = DeviceManager.bindGet();
        log.info("bindGet responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/bind/query")
    public ResponseMsg bindQuery(@RequestParam(required = false) String bindKey,@RequestParam(required = false) String did) {
        configClientV2();
        ResponseMsg<DeviceBindQueryResponse> responseMsg = DeviceManager.bindQuery(bindKey,did);
        log.info("bind query responseMsg:{}",responseMsg.toString());
        return responseMsg;
    }

    @GetMapping("/dev/child/query")
    public ResponseMsg childQuery(@RequestParam String did) {
        configClientV2();
        ResponseMsg<List<DeviceQueryDetailResponse>> responseMsg = DeviceManager.childQuery(did);
        log.info("child query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/connect/subdevice/start")
    public ResponseMsg connectSubdeviceStart(@RequestParam String did) {
        configClientV2();
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStart(did,"");
        log.info("dev connect subdevice start responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/connect/subdevice/stop")
    public ResponseMsg connectSubdeviceStop(@RequestParam String did) {
        configClientV2();
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStop(did);
        log.info("dev connect subdevice stop responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/unbind")
    public ResponseMsg unbindDev(@RequestParam String did,@RequestParam int option) {
        configClientV2();
        ResponseMsg responseMsg = DeviceManager.unbindDev(did,option);
        log.info("dev unbind responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/query/detail")
    public ResponseMsg detailQuery(@RequestParam List<String> dids) {
        configClientV2();
        ResponseMsg<List<DeviceInfoResponse>> responseMsg = DeviceManager.detailQuery(dids);
        log.info("dev query detail responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @GetMapping("/dev/timezone/update")
    public ResponseMsg updateTimeZone(@RequestParam List<String> dids,String timeZone) {
        configClientV2();
        ResponseMsg responseMsg = DeviceManager.updateTimeZone(dids,timeZone);
        log.info("updateTimeZone responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

}
