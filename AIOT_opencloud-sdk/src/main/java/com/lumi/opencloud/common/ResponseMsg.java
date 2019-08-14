package com.lumi.opencloud.common;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: zzm
 * @Date: 2019/06/01
 * @Description:
 */
@Data
@Builder
public class ResponseMsg<T> {
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误码描述
     */
    private String message;
    /**
     * 请求唯一id
     */
    private String requestId;

    private T result;

    public ResponseMsg(){
    }

    public ResponseMsg(int code, String message, String requestId, T result) {
        this.code = code;
        this.message = message;
        this.requestId = requestId;
        this.result = result;
    }
}
