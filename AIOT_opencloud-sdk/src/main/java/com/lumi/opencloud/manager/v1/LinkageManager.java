package com.lumi.opencloud.manager.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v1.request.*;
import com.lumi.opencloud.model.v1.response.*;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 17:46
 * @description
 */
public class LinkageManager extends CommonRequest {
    private static Logger log = LoggerFactory.getLogger(LinkageManager.class);

    /**
     * 	查询指定对象类型有哪些触发器
     *  Query what triggers the specified object type has (IF)
     * @return ResponseMsg
     */
    public static ResponseMsg triggerQuery(List<String> models) {
        try {
            IftttTriggerQueryRequest request = new IftttTriggerQueryRequest();
            request.setModels(models);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("triggerQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<List<IftttTriggerQueryResponse>> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("triggerQuery error:", e);
        }

        return null;
    }

    /**
     * 	查询指定的对象类型下有哪些Action
     *  Query what actions the specified object type has (Then)
     * @return ResponseMsg
     */
    public static ResponseMsg actionQuery(List<String> models) {
        try {
            IftttActionQueryRequest request = new IftttActionQueryRequest();
            request.setModels(models);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("actionQuery result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<List<IftttActionQueryResponse>> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("actionQuery error:", e);
        }

        return null;
    }

    /**
     * 	查询自动化列表
     *  Query automation list
     * @return ResponseMsg
     */
    public static ResponseMsg queryIfttt(IftttListQueryRequest request) {
        try {
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("queryIfttt result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<IftttListQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("queryIfttt error:", e);
        }

        return null;
    }

    /**
     * 	查询联动详情
     *  Query detail information of the automation
     * @return ResponseMsg
     */
    public static ResponseMsg queryIftttDetail(String iftttId) {
        try {
            IftttDetailQueryRequest request = new IftttDetailQueryRequest();
            request.setIftttId(iftttId);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(),request.requestMap());
            log.info("queryIftttDetail result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<IftttDetailQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("queryIftttDetail error:", e);
        }

        return null;
    }

    /**
     * 	创建联动
     *  Create ifttt
     * @return ResponseMsg
     */
    public static ResponseMsg createIfttt(IftttCreateRequest request) {
        try {
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(), JSON.toJSONString(request));
            log.info("createIfttt result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg<IftttCreateResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("createIfttt error:", e);
        }

        return null;
    }

    /**
     * 	删除联动
     *  Delete ifttt
     * @return ResponseMsg
     */
    public static ResponseMsg deleteIfttt(String iftttId) {
        try {
            IftttDeleteRequest request = new IftttDeleteRequest();
            request.setIftttId(iftttId);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(),JSON.toJSONString(request));
            log.info("deleteIfttt result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("deleteIfttt error:", e);
        }

        return null;
    }

    /**
     * 	打开关闭联动
     *  Enable/disable automation
     * @return ResponseMsg
     */
    public static ResponseMsg enableIfttt(String iftttId,Integer enable) {
        try {
            IftttEnableRequest request = new IftttEnableRequest();
            request.setIftttId(iftttId);
            request.setEnable(enable);
            String domain = AiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(),JSON.toJSONString(request));
            log.info("enableIfttt result:{},request:{}", result,JSON.toJSONString(request));

            ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
            return responseMsg;
        } catch (Exception e) {
            log.error("enableIfttt error:", e);
        }

        return null;
    }
}
