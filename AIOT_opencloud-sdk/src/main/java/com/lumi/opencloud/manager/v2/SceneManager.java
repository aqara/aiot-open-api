package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v2.request.*;
import com.lumi.opencloud.model.v2.response.SceneQueryDetailResponse;
import com.lumi.opencloud.model.v2.response.SceneSubjectQueryResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: heaven
 * @Date: 2019/6/4 16:21
 * @Version 1.0
 */
public class SceneManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(PropertiesManager.class);

    /**
     * 创建场景
     * create scene
     * @param request
     * @return ResponseMsg
     */
    public static ResponseMsg createScene(SceneCreateRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("createScene result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(result,0);
        } catch (Exception e) {
            log.error("createScene error:", e);
        }
        return null;
    }


    /**
     * 更新场景
     * update scene
     * @param request
     * @return ResponseMsg
     */
    public static ResponseMsg updateScene(SceneUpdateRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("updateScene result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(result,0);
        } catch (Exception e) {
            log.error("triggerDefinition error:", e);
        }
        return null;
    }

    /**
     * 删除场景
     * delete scene
     * @param sceneId
     * @return ResponseMsg
     */
    public static ResponseMsg deleteScene(String sceneId) {
        try {
            SceneDeleteRequest request = new SceneDeleteRequest();
            request.setSceneId(sceneId);

            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("deleteScene result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(result,0);
        } catch (Exception e) {
            log.error("triggerDefinition error:", e);
        }
        return null;
    }

    /**
     * 试一下执行场景
     * try the scene
     * @param request
     * @return ResponseMsg
     */
    public static ResponseMsg tryScene(SceneTryRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("tryScene result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(result,0);
        } catch (Exception e) {
            log.error("triggerDefinition error:", e);
        }
        return null;
    }

    /**
     * 执行场景
     * excute the scene
     * @param sceneId
     * @return
     */
    public static ResponseMsg runScene(String sceneId) {
        try {
            SceneRunRequest request = new SceneRunRequest();
            request.setSceneId(sceneId);

            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(AiotConfig.getAppkey()));
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(body), body);
            log.info("runScene result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(result,0);
        } catch (Exception e) {
            log.error("runScene error:", e);
        }
        return null;
    }

    /**
     * ch:查询场景的详细信息
     * en: query detail information of scene
     */
    public static ResponseMsg queryDetailScene(String sceneId) {
        try {
            SceneQueryDetailRequest request = new SceneQueryDetailRequest();
            request.setSceneId(sceneId);

            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(""), request.requestMap());
            log.info("queryDetailScene result:{},request:{}", result, JSON.toJSONString(request));

            ResponseMsg<SceneQueryDetailResponse> responseMsg = responseDecode(result,1);
            return responseMsg;
        } catch (Exception e) {
            log.error("queryDetailScene error:", e);
        }
        return null;
    }


    /**
     * ch:根据设备查询场景列表
     * en:Query scene list based on device
     */
    public static ResponseMsg querySubjectScene(String subjectId) {
        try {
            SceneSubjectQueryRequest request = new SceneSubjectQueryRequest();
            request.setSubjectId(subjectId);

            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(""), request.requestMap());
            log.info("querySubjectScene result:{},request:{}", result, JSON.toJSONString(request));

            ResponseMsg<List<SceneSubjectQueryResponse>> responseMsg = responseDecode(result,2);
            return responseMsg;
        } catch (Exception e) {
            log.error("triggerDefinition error:", e);
        }
        return null;
    }

}
