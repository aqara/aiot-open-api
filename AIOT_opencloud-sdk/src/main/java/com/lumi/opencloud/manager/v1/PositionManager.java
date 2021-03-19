package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.PositionAddRequest;
import com.lumi.opencloud.model.v1.request.PositionDeleteRequest;
import com.lumi.opencloud.model.v1.request.PositionQueryRequest;
import com.lumi.opencloud.model.v1.request.PositionUpdateRequest;
import com.lumi.opencloud.model.v1.response.PositionQueryResponse;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lvyl
 * @date 2019/7/17 16:49
 * @description
 */
public class PositionManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(PositionManager.class);

    /**
     * 	查询位置
     *  Query position
     * @return ResponseMsg
     */
    public static ResponseMsg positionQuery(AiotConfig aiotConfig,PositionQueryRequest request) {
        try {
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),request.requestMap());
            log.info("positionQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<PositionQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("positionQuery error:", e);
        }

        return null;
    }

    /**
     * 	创建位置
     *  Create position
     * @return ResponseMsg
     */
    public static ResponseMsg positionAdd(AiotConfig aiotConfig,String positionName,String parentPositionId,String description) {
        try {
            PositionAddRequest request = new PositionAddRequest();
            request.setPositionName(positionName);
            request.setParentPositionId(parentPositionId);
            request.setDescription(description);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(request));
            log.info("positionAdd result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("positionAdd error:", e);
        }

        return null;
    }

    /**
     * 	删除位置
     *  Delete position
     * @return ResponseMsg
     */
    public static ResponseMsg positionDelete(AiotConfig aiotConfig,String positionId) {
        try {
            PositionDeleteRequest request = new PositionDeleteRequest();
            request.setPositionId(positionId);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("positionDelete result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("positionDelete error:", e);
        }

        return null;
    }

    /**
     * 	更新位置
     *  Update position
     * @return ResponseMsg
     */
    public static ResponseMsg positionUpdate(AiotConfig aiotConfig,String positionId,String positionName,String description) {
        try {
            PositionUpdateRequest request = new PositionUpdateRequest();
            request.setPositionId(positionId);
            request.setPositionName(positionName);
            request.setDescription(description);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig),JSON.toJSONString(request));
            log.info("positionUpdate result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("positionUpdate error:", e);
        }

        return null;
    }
}
