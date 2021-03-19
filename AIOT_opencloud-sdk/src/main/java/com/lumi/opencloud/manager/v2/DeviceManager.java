package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v2.request.*;
import com.lumi.opencloud.model.v2.response.DeviceBindQueryResponse;
import com.lumi.opencloud.model.v2.response.DeviceInfoResponse;
import com.lumi.opencloud.model.v2.response.DeviceQueryDetailResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: lumi
 * @Date: 2019/6/19 10:54
 */
public class DeviceManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(DeviceManager.class);

    /**
     * 设备入网获取临时凭证
     * Obtain temporary credentials before the device is registered
     * @return ResponseMsg
     */
    public static ResponseMsg bindGet(AiotConfig aiotConfig) {
        try {
            DeviceBindGetRequest request = new DeviceBindGetRequest();
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null));
            log.info("bindGet result:{}", result);
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("bindGet error:", e);
        }

        return null;
    }

    /**
     * ch: 设备入网状态查询
     * en: Query device status
     * @param bindKey
     * @param did
     */
    public static ResponseMsg bindQuery(AiotConfig aiotConfig,String bindKey,String did) {
        try {
            DeviceBindQueryRequest request = new DeviceBindQueryRequest();
            request.setBindKey(bindKey);
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),request.requestMap());
            log.info("bindQuery result:{},request:{}" , result, JSON.toJSONString(request));

            ResponseMsg<DeviceBindQueryResponse> responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("bindQuery error:", e);
        }
        return null;
    }

    /**
     * ch:查看设备信息
     * en:Query device details
     * @param dids
     * @return ResponseMsg
     */
    public static ResponseMsg detailQuery(AiotConfig aiotConfig,List<String> dids) {
        try {
            DeviceQueryRequest request = new DeviceQueryRequest();
            request.setDids(dids);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null), request.requestMap());
            log.info("devInfoQuery result:{},request:{}" , result, JSON.toJSONString(request));

            ResponseMsg<List<DeviceInfoResponse>> responseMsg = responseDecode(aiotConfig,result,2);
            return responseMsg;
        } catch (Exception e) {
            log.error("devInfoQuery error:", e);
        }
        return null;
    }

    /**
     * ch:查询子设备信息
     * en:Device Management Interface
     * @param did
     * @return ResponseMsg
     */
    public static ResponseMsg childQuery(AiotConfig aiotConfig,String did) {
        try {
            DeviceChildQueryRequest request = new DeviceChildQueryRequest();
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),request.requestMap());
            log.info("childQuery result:{},request:{}" , result, JSON.toJSONString(request));

            ResponseMsg<List<DeviceQueryDetailResponse>> responseMsg = responseDecode(aiotConfig,result,2);

            return responseMsg;
        } catch (Exception e) {
            log.error("childQuery error:", e);
        }
        return null;
    }

    /**
     * 开启网关添加子设备模式
     * Enable Hub to add subdevice mode
     * @param did
     * @return ResponseMsg
     */
    public static ResponseMsg connectSubdeviceStart(AiotConfig aiotConfig,String did,String installCode) {
        try {
            DeviceConnectStartRequest request = new DeviceConnectStartRequest();
            request.setDid(did);
            request.setInstallCode(installCode);

            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body),body);
            log.info("devStart result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("devStart error:", e);
        }
        return null;
    }

    /**
     * ch:关闭网关添加子设备模式
     * en:Disable Hub to add subdevice mode
     * @param did
     * @return ResponseMsg
     */
    public static ResponseMsg connectSubdeviceStop(AiotConfig aiotConfig,String did) {
        try {
            DeviceConnectStopRequest request = new DeviceConnectStopRequest();
            request.setDid(did);

            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("connect sub device Stop result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("devStop error:", e);
        }
        return null;
    }

    /**
     * 设备解绑
     * Unbind device
     * @param did
     * @param option
     * @return ResponseMsg
     */
    public static ResponseMsg unbindDev(AiotConfig aiotConfig,String did,Integer option) {
        try {
            DeviceUnBindRequest request = new DeviceUnBindRequest();
            request.setDid(did);
            request.setOptions(option);

            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("unbindDev result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("unbindDev error:", e);
        }
        return null;
    }

    /**
     * 更新设备网关时区信息
     * Update device timeZone (only Hub device)
     * @param dids
     * @param timeZone
     * @return ResponseMsg
     */
    public static ResponseMsg updateTimeZone(AiotConfig aiotConfig,List<String> dids,String timeZone) {
        try {
            DeviceTimezoneUpdateRequest request = new DeviceTimezoneUpdateRequest();
            request.setDids(dids);
            request.setTimeZone(timeZone);

            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);

            log.info("updateTimeZone result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("updateTimeZone error:", e);
        }
        return null;
    }

}
