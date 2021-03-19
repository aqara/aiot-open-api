package com.lumi.opencloud.common;

/**
 * @author lvyl
 * @date 2019/7/15 16:58
 * @description
 */
public class CustomConfig {


    /**
     * request domain of Aqara open cloud
     * China: https://aiot-open-3rd.aqara.cn
     * USA: https://aiot-open-usa.aqara.com
     * Europe:https://open-ger.aqara.com
     * Korea: https://open-kr.aqara.com
     * Russia: https://open-ru.aqara.com
     */
//    public static final String DOMAIN = "https://aiot-test.aqara.com/opencloud";
    public static final String DOMAIN = "https://aiot-open-usa.aqara.com";

    public static String DOMAIN_V1 = DOMAIN + "/3rd/v1.0/open";
    public static String DOMAIN_V2 = DOMAIN + "/v2.0/open";
	

    /**
     * please change to your appid register in aqara open cloud
     */
    public static String Appid = "4d6382d971361476664c465a";

    /**
     * please change to your appkey register in aqara open cloud
     */
    public static String Appkey = "S0X1TUwz12uFlmDEwWcyx27kASRC91eI";

    /**
     * Choose a language：ch Chinese,en English
     */
    public static String Lang = "en";

    /**
     * Message receive body
     * NormalMode:0
     * SecurityMode:2
     */
    public static int SecurityMode = 0;

}
