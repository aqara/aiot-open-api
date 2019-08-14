package com.lumi.opencloud.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: zzm
 * @Date: 2019/06/01
 * @Description:
 */
public abstract class BaseRequest implements Serializable{
    private static final long serialVersionUID = 1797870058501212195L;

    /**
     * 访问地址
     * @return
     */
    public abstract String uri();

    /**
     * 参数校验
     * @return
     */
    public boolean paramValid(){
        return true;
    }

    public Map<String,Object> requestMap(){
        return null;
    }
}
