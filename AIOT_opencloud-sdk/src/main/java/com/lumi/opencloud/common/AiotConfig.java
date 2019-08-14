package com.lumi.opencloud.common;

/**
 * @author lvyl
 * @date 2019/7/19 10:33
 * @description
 */
public class AiotConfig {

    /**
     * 应用ID
     */
    private static String Appid;

    /**
     * 应用key
     */
    private static String Appkey;

    /**
     * 域名
     */
    private static String Domain;

    /**
     * 语言
     */
    private static String Lang;

    /**
     * v1.0授权token
     */
    private static String Accesstoken;

    public static void setClientV1(String appId,String appKey,String accessToken,String lang, String domain){
        Appid = appId;
        Appkey = appKey;
        Accesstoken = accessToken;
        Lang = lang;
        Domain = domain;
    }

    public static void setClientV2(String appId,String appKey,String lang,String domain){
        Appid = appId;
        Appkey = appKey;
        Lang = lang;
        Domain = domain;
    }

    public static String getAppid() {
        return Appid;
    }

    public static void setAppid(String appid) {
        Appid = appid;
    }

    public static String getAppkey() {
        return Appkey;
    }

    public static void setAppkey(String appkey) {
        Appkey = appkey;
    }

    public static String getDomain() {
        return Domain;
    }

    public static void setDomain(String domain) {
        Domain = domain;
    }

    public static String getLang() {
        return Lang;
    }

    public static void setLang(String lang) {
        Lang = lang;
    }

    public static String getAccesstoken() {
        return Accesstoken;
    }

    public static void setAccesstoken(String accesstoken) {
        Accesstoken = accesstoken;
    }
}
