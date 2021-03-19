package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.*;
import com.lumi.opencloud.model.v1.response.DeviceInfoResponse;
import com.lumi.opencloud.model.v1.response.DeviceQueryResponse;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/16 14:06
 * @description
 */
public class DeviceManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(DeviceManager.class);

    /**
     * 	查询设备
     * Query device
     * @return ResponseMsg
     */
    public static ResponseMsg deviceQuery(AiotConfig aiotConfig,DeviceQueryRequest request) {
        try {
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),request.requestMap());
            log.info("deviceQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<DeviceQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deviceQuery error:", e);
        }

        return null;
    }

    /**
     * 	更新设备信息
     * update device
     * @return ResponseMsg
     */
    public static ResponseMsg deviceUpdate(AiotConfig aiotConfig,String did,String name) {
        try {
            DeviceUpdateRequest request = new DeviceUpdateRequest();
            request.setDid(did);
            request.setName(name);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(request));
            log.info("deviceUpdate result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deviceUpdate error:", e);
        }

        return null;
    }

    /**
     * 	开启子设备入网
     *  Enable Hub to add subdevice mode
     *  @param did 网关id
     * @return ResponseMsg
     */
    public static ResponseMsg deviceConnect(AiotConfig aiotConfig,String did) {
        try {
            DeviceConnectRequest request = new DeviceConnectRequest();
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("deviceConnect result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deviceConnect error:", e);
        }

        return null;
    }

    /**
     * 	关闭子设备入网
     *  Disable Hub to add subdevice mode
     *  @param did 网关id
     * @return ResponseMsg
     */
    public static ResponseMsg deviceConnectStop(AiotConfig aiotConfig,String did) {
        try {
            DeviceConnectStopRequest request = new DeviceConnectStopRequest();
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("deviceConnectStop result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deviceConnectStop error:", e);
        }

        return null;
    }

    /**
     * 查询网关下子设备信息
     * Query sub-device information based on the Hub
     * @param did 网关id
     * @return ResponseMsg
     */
    public static ResponseMsg childQuery(AiotConfig aiotConfig,String did) {
        try {
            DeviceChildQueryRequest request = new DeviceChildQueryRequest();
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),request.requestMap());
            log.info("childQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<List<DeviceInfoResponse>> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deviceConnectStop error:", e);
        }

        return null;
    }

    /**
     * 设备解绑(网关和子设备)
     * Unbind device
     * @param did 设备id
     * @return ResponseMsg
     */
    public static ResponseMsg unbindDev(AiotConfig aiotConfig,String did,Integer option) {
        try {
            DeviceUnbindRequest request = new DeviceUnbindRequest();
            request.setDid(did);
            request.setOption(option);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("unbindDev result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("unbindDev error:", e);
        }

        return null;
    }
}
