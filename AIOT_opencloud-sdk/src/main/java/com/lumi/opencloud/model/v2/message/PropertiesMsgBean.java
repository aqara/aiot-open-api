package com.lumi.opencloud.model.v2.message;

import java.io.Serializable;

/**
 * @Author: zzm
 * @Date: 2019/06/01
 * @Description:
 */
public class PropertiesMsgBean implements Serializable{
    private static final long serialVersionUID = -685386260185916306L;

    /**
     * 设备id
     */
    private String did;

    /**
     * 时间戳 毫秒
     */
    private String time;

    /**
     * 资源属性
     */
    private String property;

    /**
     * 属性值
     */
    private String value;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
