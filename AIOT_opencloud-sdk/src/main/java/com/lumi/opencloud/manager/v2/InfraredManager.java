package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.ir.request.*;
import com.lumi.opencloud.model.v2.response.DeviceBindQueryResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :红外设备管理 Infrared device manager
 * @Date : 2021/3/23 12:00 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class InfraredManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(InfraredManager.class);

    /**
     * 开启红外学习
     * start to learn ircode
     * @param aiotConfig
     * @param did
     * @param timeLength
     * @return
     */
    public static ResponseMsg learnStart(AiotConfig aiotConfig,String did,int timeLength){
        try {
            IrLearnStartRequest irLearnStartRequest = new IrLearnStartRequest();
            irLearnStartRequest.setDid(did);
            irLearnStartRequest.setTimeLength(timeLength);
            String domain = aiotConfig.getDomain() + irLearnStartRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),irLearnStartRequest.requestMap());
            log.info("Ir leart start result:{},request:{}" , result, JSON.toJSONString(irLearnStartRequest));

            ResponseMsg<DeviceBindQueryResponse> responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn start error:", e);
        }
        return null;
    }

    /**
     * 取消红外学习
     * cancel learn ircode
     * @param aiotConfig
     * @param did
     * @return
     */
    public static ResponseMsg learnCancel(AiotConfig aiotConfig,String did){
        try {
            IrLearnCancelRequest irLearnCancelRequest = new IrLearnCancelRequest();
            irLearnCancelRequest.setDid(did);
            String domain = aiotConfig.getDomain() + irLearnCancelRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),irLearnCancelRequest.requestMap());
            log.info("Ir learn cancel result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn cancel error:", e);
        }
        return null;
    }

    /**
     * 红外学习结果
     * learn ircode result
     * @param aiotConfig
     * @param did
     * @param keyId
     * @return
     */
    public static ResponseMsg learnResult(AiotConfig aiotConfig,String did,String keyId){
        try {
            IrLearnResultRequest irLearnResultRequest = new IrLearnResultRequest();
            irLearnResultRequest.setDid(did);
            irLearnResultRequest.setKeyId(keyId);
            String domain = aiotConfig.getDomain() + irLearnResultRequest.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),irLearnResultRequest.requestMap());
            log.info("Ir learn result result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir learn result error:", e);
        }
        return null;
    }

    /**
     * 添加红外码
     * add ircode key
     * @param aiotConfig
     * @param request
     * @return
     */
    public static ResponseMsg keyAdd(AiotConfig aiotConfig, IrKeyAddRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("Ir key add result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("Ir key add error:", e);
        }
        return null;
    }

    /**
     * 删除红外码
     * delete ircode
     * @param aiotConfig
     * @param request
     * @return
     */
    public static ResponseMsg keyDel(AiotConfig aiotConfig, IrKeyDelRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("Ir key del result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("Ir key del error:", e);
        }
        return null;
    }

    /**
     * 更新红外码
     * update ircode
     * @param aiotConfig
     * @param request
     * @return
     */
    public static ResponseMsg keyUpdate(AiotConfig aiotConfig, IrKeyUpdateRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("Ir key update result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("Ir key update error:", e);
        }
        return null;
    }

    /**
     * 查询设备所有红外码
     * query device ircode list
     * @param aiotConfig
     * @param did
     * @return
     */
    public static ResponseMsg keyInfo(AiotConfig aiotConfig,String did){
        try {
            IrKeyInfoRequest request = new IrKeyInfoRequest();
            request.setDid(did);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),request.requestMap());
            log.info("Ir key info result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir key info error:", e);
        }
        return null;
    }


    /**
     * 获取设备类型列表
     * query device category list
     * @param aiotConfig
     * @return
     */
    public static ResponseMsg categories(AiotConfig aiotConfig){
        try {
            IrCategoryRequest request = new IrCategoryRequest();
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null));
            log.info("Ir categories result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir categories error:", e);
        }
        return null;
    }

    /**
     * 根据设备类型获取品牌列表
     * query category brands
     * @param aiotConfig
     * @param categoryId
     * @return
     */
    public static ResponseMsg categoryBrands(AiotConfig aiotConfig,String categoryId){
        try {
            IrCategoryBrandRequest request = new IrCategoryBrandRequest();
            request.setCategoryId(categoryId);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),request.requestMap());
            log.info("Ir key info result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir key info error:", e);
        }
        return null;
    }

    /**
     * 匹配树信息
     * match data
     * @param aiotConfig
     * @param request
     * @return
     */
    public static ResponseMsg matchData(AiotConfig aiotConfig, IrMatchDataRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("Ir match data result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("Ir match data error:", e);
        }
        return null;
    }

    /**
     * 获取遥控器所有按键信息
     * query controller keys info
     * @param aiotConfig
     * @param controllerIds
     * @return
     */
    public static ResponseMsg controllerKeys(AiotConfig aiotConfig, List<Integer> controllerIds){
        try {
            IrControllerKeysRequest request = new IrControllerKeysRequest();
            request.setControllerIds(controllerIds);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null),request.requestMap());
            log.info("Ir controller keys result:{}", result);

            ResponseMsg responseMsg = responseDecode(aiotConfig,result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("Ir controller keys error:", e);
        }
        return null;
    }

    /**
     * 单击遥控器按键
     * click key
     * @param aiotConfig
     * @param request
     * @return
     */
    public static ResponseMsg keyClick(AiotConfig aiotConfig, IrKeyClickRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("Ir key click result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("Ir key click error:", e);
        }
        return null;
    }

}