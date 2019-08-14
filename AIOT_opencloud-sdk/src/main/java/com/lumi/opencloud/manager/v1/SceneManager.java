package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.*;
import com.lumi.opencloud.model.v1.response.SceneCreateResponse;
import com.lumi.opencloud.model.v1.response.SceneListQueryResponse;
import com.lumi.opencloud.model.v1.response.SceneQueryDetailResponse;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lvyl
 * @date 2019/7/17 19:07
 * @description
 */
public class SceneManager extends CommonRequest {
    private static Logger log = LoggerFactory.getLogger(SceneManager.class);

    /**
     * 	查询场景列表
     *  Query scene list
     * @return ResponseMsg
     */
    public static ResponseMsg querySceneList(SceneListQueryRequest request) {
        try {
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("querySceneList result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<SceneListQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("querySceneList error:", e);
        }

        return null;
    }

    /**
     * 	查询场景详情
     *  Query scene list
     * @return ResponseMsg
     */
    public static ResponseMsg querySceneDetail(String sceneId) {
        try {
            SceneDetailQueryRequest request = new SceneDetailQueryRequest();
            request.setSceneId(sceneId);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("querySceneDetail result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<SceneQueryDetailResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("querySceneDetail error:", e);
        }

        return null;
    }

    /**
     * 	创建场景
     *  Create scene
     * @return ResponseMsg
     */
    public static ResponseMsg createScene(SceneCreateRequest request) {
        try {
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(), JSON.toJSONString(request));
            log.info("createScene result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<SceneCreateResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("createScene error:", e);
        }

        return null;
    }

    /**
     * 	删除场景
     *  Create scene
     * @return ResponseMsg
     */
    public static ResponseMsg deleteScene(String sceneId) {
        try {
            SceneDeleteRequest request = new SceneDeleteRequest();
            request.setSceneId(sceneId);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(),JSON.toJSONString(request));
            log.info("deleteScene result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deleteScene error:", e);
        }

        return null;
    }

    /**
     * 	删除场景
     *  Create scene
     * @return ResponseMsg
     */
    public static ResponseMsg runScene(String sceneId) {
        try {
            SceneRunRequest request = new SceneRunRequest();
            request.setSceneId(sceneId);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(),JSON.toJSONString(request));
            log.info("runScene result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("runScene error:", e);
        }

        return null;
    }
}
