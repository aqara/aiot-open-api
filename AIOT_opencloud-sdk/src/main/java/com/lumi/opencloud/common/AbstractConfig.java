package com.lumi.opencloud.common;

/**
 * @author lvyl
 * @date 2019/7/19 12:01
 * @description
 */
public class AbstractConfig {

    public void configClientV1(String token){
        String appId = TestConstants.Appid;
        String appKey = TestConstants.Appkey;
        String lang = TestConstants.Lang;
        String domain = TestConstants.DOMAIN_V1;
        AiotConfig.setClientV1(appId,appKey,token,lang,domain);
    }

    public void configClientV2(){
        String appId = TestConstants.Appid;
        String appKey = TestConstants.Appkey;
        String lang = TestConstants.Lang;
        String domain = TestConstants.DOMAIN_V2;
        AiotConfig.setClientV2(appId,appKey,lang,domain);
    }
}
