package com.lumi.opencloud.controller.v2;

import com.lumi.opencloud.common.AbstractConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.OtaManager;
import com.lumi.opencloud.model.v2.request.OtaFirmwareUpgradeDetail;
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
public class OpenApiV2OtaTest extends AbstractConfig {

    private static Logger log = LoggerFactory.getLogger(OpenApiV2OtaTest.class);

    @GetMapping("/ota/firmware/query")
    public ResponseMsg firmwareQuery(@RequestParam String model) {
        configClientV2();
        ResponseMsg responseMsg = OtaManager.firmwareQuery(model);
        log.info("firmware query responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ota/upgrade/firmware")
    public ResponseMsg firmwareUpgrade(@RequestBody List<OtaFirmwareUpgradeDetail> data) {
        configClientV2();
        ResponseMsg responseMsg = OtaManager.firmwareUpgrade(data);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

    @PostMapping("/ota/upgrade/query")
    public ResponseMsg upgradeQuery(@RequestParam List<String> dids) {
        configClientV2();
        ResponseMsg responseMsg = OtaManager.upgradeQuery(dids);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());

        return responseMsg;
    }

}
