package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v2.request.OtaFirmwareQueryRequest;
import com.lumi.opencloud.model.v2.request.OtaFirmwareUpgradeDetail;
import com.lumi.opencloud.model.v2.request.OtaFirmwareUpgradeRequest;
import com.lumi.opencloud.model.v2.request.OtaUpgradeQueryRequest;
import com.lumi.opencloud.model.v2.response.OtaFwQueryResponse;
import com.lumi.opencloud.model.v2.response.OtaFwUpgradeResponse;
import com.lumi.opencloud.model.v2.response.OtaUpgradeQueryResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/16 11:21
 * @description
 */
public class OtaManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(OtaManager.class);

    /**
     * 查看最新固件
     * Query all firmwares based on model
     * @param model
     * @return
     */
    public static ResponseMsg firmwareQuery(String model) {
        try {
            OtaFirmwareQueryRequest request = new OtaFirmwareQueryRequest();
            request.setModel(model);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(""), request.requestMap());
            log.info("firmwareQuery result:{},request:{}", result, JSON.toJSONString(request));

            ResponseMsg<List<OtaFwQueryResponse>> responseMsg = responseDecode(result,2);
            return responseMsg;
        } catch (Exception e) {
            log.error("firmwareQuery error:", e);
        }
        return null;
    }

    /**
     * 升级固件（一键升级多个固件）
     * Upgrade firmware
     * @param data
     * @return
     */
    public static ResponseMsg firmwareUpgrade(List<OtaFirmwareUpgradeDetail> data) {
        try {
            OtaFirmwareUpgradeRequest request = new OtaFirmwareUpgradeRequest();
            request.setData(data);
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("firmwareUpgrade result:{},request:{}", result, JSON.toJSONString(request));

            ResponseMsg<List<OtaFwUpgradeResponse>> responseMsg = responseDecode(result,2);
            return responseMsg;
        } catch (Exception e) {
            log.error("firmwareUpgrade error:", e);
        }
        return null;
    }

    /**
     * 查询设备升级的状态
     * Query the upgrade status
     * @param dids
     * @return
     */
    public static ResponseMsg upgradeQuery(List<String> dids) {
        try {
            OtaUpgradeQueryRequest request = new OtaUpgradeQueryRequest();
            request.setDids(dids);
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("upgradeQuery result:{},request:{}", result, JSON.toJSONString(request));

            ResponseMsg<List<OtaUpgradeQueryResponse>> responseMsg = responseDecode(result,2);
            return responseMsg;
        } catch (Exception e) {
            log.error("upgradeQuery error:", e);
        }
        return null;
    }
}
