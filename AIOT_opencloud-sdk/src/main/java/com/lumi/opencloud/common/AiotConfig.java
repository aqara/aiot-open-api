package com.lumi.opencloud.common;

/**
 * @author lvyl
 * @date 2019/7/19 10:33
 * @description
 */
public class AiotConfig {

    /**
     * application ID
     */
    private String appId;

    /**
     * application key
     */
    private String appKey;

    /**
     *
     * request domain of Aqara open cloud
     *      China: https://aiot-open-3rd.aqara.cn
     *      USA: https://aiot-open-usa.aqara.com
     *      Europe:https://open-ger.aqara.com
     *      Korea: https://open-kr.aqara.com
     *      Russia: https://open-ru.aqara.com
     *
     */
    private String domain;

    /**
     * language
     */
    private String lang;

    /**
     * access token
     */
    private String accessToken;

    public AiotConfig(String appId, String appKey, String accessToken, String lang, String domain){
        this.appId = appId;
        this.appKey = appKey;
        this.accessToken = accessToken;
        this.lang = lang;
        this.domain = domain;
    }

    public AiotConfig(String appId,String appKey,String lang,String domain){
        this.appId = appId;
        this.appKey = appKey;
        this.lang = lang;
        this.domain = domain;
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


}
