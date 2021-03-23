package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.ir.*;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/22 2:45 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class InfraredManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(InfraredManager.class);

    /**
     * query device type categories
     * @param aiotConfig
     * @return
     */
    public static ResponseMsg categories(AiotConfig aiotConfig){
        try {
            String domain = aiotConfig.getDomain() + new IrCategoryRequest().uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig));
            log.info("Ir query categories result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir query categories error:", e);
        }

        return null;
    }

    public static ResponseMsg categoryBrands(AiotConfig aiotConfig,int categoryId){
        try {
            IrCategoryBrandRequest irCategoryBrandRequest = new IrCategoryBrandRequest();
            irCategoryBrandRequest.setCategoryId(categoryId);
            String domain = aiotConfig.getDomain() + irCategoryBrandRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irCategoryBrandRequest.requestMap());
            log.info("Ir query category brands result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir query category brands error:", e);
        }
        return null;
    }

    public static ResponseMsg matchData(AiotConfig aiotConfig, IrMatchDataRequest irMatchDataRequest){
        try {
            String domain = aiotConfig.getDomain() + irMatchDataRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(irMatchDataRequest));
            log.info("Ir match data result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir match data error:", e);
        }
        return null;
    }

    public static ResponseMsg controllerAdd(AiotConfig aiotConfig, IrControllerAddRequest irControllerAddRequest){
        try {
            String domain = aiotConfig.getDomain() + irControllerAddRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(irControllerAddRequest));
            log.info("Ir controller add result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller add error:", e);
        }
        return null;
    }

    public static ResponseMsg controllerDel(AiotConfig aiotConfig,String did){
        try {
            IrControllerDelRequest irControllerDelRequest = new IrControllerDelRequest();
            irControllerDelRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irControllerDelRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(irControllerDelRequest));
            log.info("Ir controller delete result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller delete error:", e);
        }
        return null;
    }

    public static ResponseMsg controllerUpdate(AiotConfig aiotConfig,String did,String name){
        try {
            IrControllerUpdateRequest irControllerUpdateRequest = new IrControllerUpdateRequest();
            irControllerUpdateRequest.setDid(did);
            irControllerUpdateRequest.setName(name);
            String domain = aiotConfig.getDomain() + irControllerUpdateRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(irControllerUpdateRequest));
            log.info("Ir controller delete result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller delete error:", e);
        }
        return null;
    }

    public static ResponseMsg controllerInfo(AiotConfig aiotConfig,String did){
        try {
            IrControllerInfoRequest irControllerInfoRequest = new IrControllerInfoRequest();
            irControllerInfoRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irControllerInfoRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irControllerInfoRequest.requestMap());
            log.info("Ir controller info result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller info error:", e);
        }
        return null;
    }

    public static ResponseMsg controllerList(AiotConfig aiotConfig,String did){
        try {
            IrControllerListRequest irControllerListRequest = new IrControllerListRequest();
            irControllerListRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irControllerListRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irControllerListRequest.requestMap());
            log.info("Ir controller list result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller list error:", e);
        }
        return null;
    }

    public static ResponseMsg keyClick(AiotConfig aiotConfig, IrKeyClickRequest irKeyClickRequest){
        try {
            String domain = aiotConfig.getDomain() + irKeyClickRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(irKeyClickRequest));
            log.info("Ir key click result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir key click error:", e);
        }
        return null;
    }

    public static ResponseMsg acState(AiotConfig aiotConfig,String did){
        try {
            IrACStateRequest irACStateRequest = new IrACStateRequest();
            irACStateRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irACStateRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irACStateRequest.requestMap());
            log.info("Ir AC state result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir AC state error:", e);
        }
        return null;
    }

    public static ResponseMsg remoteFunctions(AiotConfig aiotConfig,String did,int remoteId){
        try {
            IrRemoteFunctionRequest irRemoteFunctionRequest = new IrRemoteFunctionRequest();
            irRemoteFunctionRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irRemoteFunctionRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irRemoteFunctionRequest.requestMap());
            log.info("Ir query functions result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir query functions error:", e);
        }
        return null;
    }

    public static ResponseMsg remoteKeys(AiotConfig aiotConfig,String remoteId){
        try {
            String domain = aiotConfig.getDomain() + "/controller/remotes/"+remoteId+"/keys";
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig));
            log.info("Ir query remote keys result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir query remote keys error:", e);
        }
        return null;
    }

    public static ResponseMsg learnStart(AiotConfig aiotConfig,String did,int timeLength){
        try {
            IrLearnStartRequest irLearnStartRequest = new IrLearnStartRequest();
            irLearnStartRequest.setDid(did);
            irLearnStartRequest.setTimeLength(timeLength);
            String domain = aiotConfig.getDomain() + irLearnStartRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irLearnStartRequest.requestMap());
            log.info("Ir learn start result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn start error:", e);
        }
        return null;
    }

    public static ResponseMsg learnCancel(AiotConfig aiotConfig,String did){
        try {
            IrLearnCancelRequest irLearnCancelRequest = new IrLearnCancelRequest();
            irLearnCancelRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irLearnCancelRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irLearnCancelRequest.requestMap());
            log.info("Ir learn cancel result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn cancel error:", e);
        }
        return null;
    }

    public static ResponseMsg learnResult(AiotConfig aiotConfig,String did,String keyId){
        try {
            IrLearnResultRequest irLearnResultRequest = new IrLearnResultRequest();
            irLearnResultRequest.setDid(did);
            irLearnResultRequest.setKeyId(keyId);
            String domain = aiotConfig.getDomain() + irLearnResultRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),irLearnResultRequest.requestMap());
            log.info("Ir learn result result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn result error:", e);
        }
        return null;
    }

    public static ResponseMsg customControllerAdd(AiotConfig aiotConfig,IrDeviceCustomRequest irDeviceCustomRequest){
        try {
            String domain = aiotConfig.getDomain() + irDeviceCustomRequest.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(irDeviceCustomRequest));
            log.info("Ir custom controller add result:{}", result);

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir custom controller add error:", e);
        }
        return null;
    }

}