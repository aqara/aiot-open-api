package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.*;
import com.lumi.opencloud.model.v1.response.ResourceHistoryQueryResponse;
import com.lumi.opencloud.model.v1.response.ResourceNameQueryResponse;
import com.lumi.opencloud.model.v1.response.ResourceQueryResponse;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 16:49
 * @description
 */
public class ResourceManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(ResourceManager.class);

    /**
     * 	查询资源
     *  Query resource
     * @return ResponseMsg
     */
    public static ResponseMsg query(AiotConfig aiotConfig,List<ResourceQueryInfo> infoList) {
        try {
            ResourceQueryRequest request = new ResourceQueryRequest();
            request.setData(infoList);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(request));
            log.info("resource query result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<List<ResourceQueryResponse>> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource query error:", e);
        }

        return null;
    }

    /**
     * 	查询资源
     *  Query resource
     * @return ResponseMsg
     */
    public static ResponseMsg queryName(AiotConfig aiotConfig, List<ResourceQueryInfo> infoList) {
        try {
            ResourceNameQueryRequest request = new ResourceNameQueryRequest();
            request.setData(infoList);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(request));
            log.info("resource name query result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<List<ResourceNameQueryResponse>> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource query error:", e);
        }

        return null;
    }

    /**
     * 	更新资源
     *  update resource
     * @return ResponseMsg
     */
    public static ResponseMsg update(AiotConfig aiotConfig,ResourceUpdateRequest request) {
        try {
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("resource update result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource update error:", e);
        }

        return null;
    }

    /**
     * 	订阅资源
     *  subscriber resource
     * @return ResponseMsg
     */
    public static ResponseMsg subscriber(AiotConfig aiotConfig,List<ResourceSubscribeInfo> infoList) {
        try {
            ResourceSubscribeRequest request = new ResourceSubscribeRequest();
            request.setData(infoList);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("resource subscriber result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource subscriber error:", e);
        }

        return null;
    }

    /**
     * 	取消订阅资源
     *  un subscriber resource
     * @return ResponseMsg
     */
    public static ResponseMsg unsubscriber(AiotConfig aiotConfig,List<ResourceSubscribeInfo> infoList) {
        try {
            ResourceUnSubscribeRequest request = new ResourceUnSubscribeRequest();
            request.setData(infoList);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("resource unsubscriber result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource unsubscriber error:", e);
        }

        return null;
    }

    /**
     * 	查询资源历史
     *  resource historyQuery
     * @return ResponseMsg
     */
    public static ResponseMsg historyQuery(AiotConfig aiotConfig,ResourceHistoryQueryRequest request) {
        try {
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("resource historyQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<ResourceHistoryQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("resource historyQuery error:", e);
        }

        return null;
    }

    /**
     * 	查询资源聚合
     *  resource historyQuery
     * @return ResponseMsg
     */
    public static ResponseMsg queryResourceStatistics(AiotConfig aiotConfig,ResourceStatisticsQueryRequest request) {
        try {
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("resource Statistics Query result:{},request:{}", result,JSON.toJSONString(request));

            return JSONObject.parseObject(result,ResponseMsg.class);
        } catch (Exception e) {
            log.error("resource Statistics Query error:", e);
        }

        return null;
    }
}
