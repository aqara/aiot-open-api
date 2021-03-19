package com.lumi.opencloud.manager.v2;

import com.alibaba.fastjson.JSON;
import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CommonRequest;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.model.v2.request.*;
import com.lumi.opencloud.model.v2.response.PropertiesHistoryQueryResponse;
import com.lumi.opencloud.model.v2.response.PropertiesQueryResponse;
import com.lumi.opencloud.util.AESUtil;
import com.lumi.opencloud.util.PooledHttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/16 11:21
 * @description
 */
public class PropertiesManager extends CommonRequest {

    private static Logger log = LoggerFactory.getLogger(PropertiesManager.class);

    /**
     * 提交控制指令
     * Submit device control instructions
     * @param request
     * @return
     */
    public static ResponseMsg write(AiotConfig aiotConfig,PropertiesWriteRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("properties write result:{},request:{}", result, JSON.toJSONString(request));
            return responseDecode(aiotConfig,result,0);
        } catch (Exception e) {
            log.error("properties write error:", e);
        }
        return null;
    }

    /**
     * 查询设备当前属性值
     * Query the current attribute value of the device
     * @param infoList
     * @return
     */
    public static ResponseMsg query(AiotConfig aiotConfig,List<PropertiesQueryInfo> infoList) {
        try {
            PropertiesQueryRequest request = new PropertiesQueryRequest();
            request.setData(infoList);
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("properties query result:{},request:{}", result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,2);
        } catch (Exception e) {
            log.error("properties query error:", e);
        }
        return null;
    }

    /**
     * 查询设备属性的历史值（最大返回300）（仅可查询7天）
     * Query the history of device attributes (Maximum : 300)(available for 7days only)
     * @param request
     * @return
     */
    public static ResponseMsg historyQuery(AiotConfig aiotConfig,ResourceHistoryQueryRequest request) {
        try {
            String body = AESUtil.encryptCbc(JSON.toJSONString(request), AESUtil.getAESKey(aiotConfig.getAppKey()));
            String domain = aiotConfig.getDomain() + request.uri();
            String result = PooledHttpClientUtils.doPost(domain, constructHeaderV2(aiotConfig,body), body);
            log.info("properties history query result:{},request:{}", result, JSON.toJSONString(request));

            return responseDecode(aiotConfig,result,2);
        } catch (Exception e) {
            log.error("properties history query error:", e);
        }
        return null;
    }
}
