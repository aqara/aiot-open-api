package com.lumi.opencloud.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/05
 * @Description:
 */
@Slf4j
public abstract class MapUtils {

    /**
     * Bean to Map,null not to map
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if(obj == null){
            return null;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Map<String, Object> map = new HashMap<String, Object>(propertyDescriptors.length);
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                /**
                 *过滤class属性
                 */

                if (!"class".equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if(null != value){
                        map.put(key, value);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            log.error("transBean2Map error:", e);
        }
        return null;
    }


    /**
     * Map to bean
     * @param maps
     * @param class1
     * @return
     */
    public static<T> T transMap2Bean(Map<String, Object> maps, Class<T> class1) {
        try {
            T bean = class1.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(class1);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                /**
                 *过滤class属性
                 */
                if (!"class".equals(key)) {
                    // 得到property对应的setter方法
                    Object value = maps.get(key);
                    if(value instanceof Map){
                        value = transMap2Bean((Map) value, property.getPropertyType());
                    }
                    if(null != value){
                        Method getter = property.getWriteMethod();
                        getter.invoke(bean, value);
                    }
                }
            }
            return bean;
        } catch (Exception e) {
            log.error("transMap2Bean error:", e);
        }
        return null;
    }

    @Data
    private static class TestBean1{
        private String a1;
        private TestBean2 b2;
        private List<TestBean2> b3;
    }

    @Data
    private static class TestBean2{
        private String a2;
    }
}
