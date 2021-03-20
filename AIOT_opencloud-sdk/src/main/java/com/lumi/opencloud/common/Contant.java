package com.lumi.opencloud.common;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :
 * @Date : 2021/3/19 6:19 下午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class Contant {

    /**
     * domain url
     * 各区域请求地址
     */
    public enum Domain{
        /**
         *
         */
        CHINA("https://aiot-open-3rd.aqara.cn"),
        USA("https://aiot-open-usa.aqara.com"),
        EUROPE("https://open-ger.aqara.com"),
        KOREA("https://open-kr.aqara.com"),
        RUSSIA("https://open-ru.aqara.com");

        String url;

        Domain(String url){
            this.url=url;
        }

    }
}