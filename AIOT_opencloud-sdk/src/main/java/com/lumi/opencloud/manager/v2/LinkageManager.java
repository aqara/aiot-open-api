package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v2.request.*;
import com.lumi.opencloud.model.v2.response.IftttActionDefinitionResponse;
import com.lumi.opencloud.model.v2.response.IftttLinkageDetailResponse;
import com.lumi.opencloud.model.v2.response.IftttSubjectQueryResponse;
import com.lumi.opencloud.model.v2.response.IftttTriggerDefinitionResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Author: heaven
 * @Date: 2019/6/20 09:59
 */
public class LinkageManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(LinkageManager.class);

    /**
     * ch:查询指定的对象类型下有哪些触发器（IF)
     * en:Query what triggers the specified object type has (IF)
     */
    public static ResponseMsg triggerDefinitionQuery(AiotConfig aiotConfig,List<String> models) {
        try {
            IftttTriggerDifinitionQueryRequest request = new IftttTriggerDifinitionQueryRequest();
            request.setModels(models);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null), request.requestMap());
            log.info("triggerDefinition result:{},request:{}" , result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,2);
        } catch (Exception e) {
            log.error("triggerDefinition error:", e);
        }
        return null;
    }

    /**
     * ch:查询指定的对象类型下有哪些Action（Then）
     * en:Query what actions the specified object type has (Then)
     */
    public static ResponseMsg actionDefinitionQuery(AiotConfig aiotConfig,List<String> models) {
        try {
            IftttActionDifinitionQueryRequest request = new IftttActionDifinitionQueryRequest();
            request.setModels(models);
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null), request.requestMap());
            log.info("actionDefinition result:{},request:{}" , result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,2);
        } catch (Exception e) {
            log.error("actionDefinition error:", e);
        }
        return null;
    }


    /**
     * 创建联动
     * Create automation
     * @param request
     * @return ResponseMsg
     */
    public static ResponseMsg createIfttt(AiotConfig aiotConfig,IftttCreateRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSONObject.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("createIfttt result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("createIfttt error:", e);
        }
        return null;
    }

    /**
     * ch:修改联动信息
     * en: update the automation detail infomation
     */
    public static ResponseMsg updateIfttt(AiotConfig aiotConfig,IftttUpdateRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("updateIfttt result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("updateIfttt error:", e);
        }
        return null;
    }


    /**
     * ch:删除联动
     * en: delete automation
     */
    public static ResponseMsg deleteIfttt(AiotConfig aiotConfig,String linkageId) {
        try {
            IftttDeleteRequest request = new IftttDeleteRequest();
            request.setLinkageId(linkageId);

            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("deleteIfttt result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("deleteIfttt error:", e);
        }
        return null;
    }

    /**
     * ch:打开/关闭联动
     * en: enable/disable automation
     * @param linkageId
     * @param state
     */
    public static ResponseMsg enableIfttt(AiotConfig aiotConfig,String linkageId,Integer state) {
        try {
            IftttEnableRequest request = new IftttEnableRequest();
            request.setLinkageId(linkageId);
            request.setState(state);

            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("enableIfttt result:{},request:{}" , result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("enableIfttt error:", e);
        }
        return null;
    }

    /**
     * ch:查询联动详细信息
     * en:query detail information of the automation
     */
    public static ResponseMsg queryDetail(AiotConfig aiotConfig,String linkageId) {
        try {
            IftttQueryDetailRequest request = new IftttQueryDetailRequest();
            request.setLinkageId(linkageId);

            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null), request.requestMap());
            log.info("queryDetail result:{},request:{}" , result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,1);
        } catch (Exception e) {
            log.error("queryDetail error:", e);
        }
        return null;
    }

    /**
     * ch:根据对象查询自动化列表
     * en:Query automation list based on object
     */
    public static ResponseMsg subjectQuery(AiotConfig aiotConfig,String subjectId) {
        try {
            IftttSubjectQueryRequest request = new IftttSubjectQueryRequest();
            request.setSubjectId(subjectId);

            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doGet(domain, constructHeaderV2(aiotConfig,null), request.requestMap());
            log.info("subjectQuery result:{},request:{}" , result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,2);
        } catch (Exception e) {
            log.error("subjectQuerys error:", e);
        }
        return null;
    }
}
