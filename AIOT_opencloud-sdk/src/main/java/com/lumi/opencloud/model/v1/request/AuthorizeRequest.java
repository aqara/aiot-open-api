package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/30 20:05
 * @description
 */
@Getter
@Setter
public class AuthorizeRequest extends BaseRequest {

    private static final long serialVersionUID = 7623426880956440718L;

    private String clientId;

    /**
     * response_type = code
     */
    private String responseType;

    private String redirectUri;

    private String state;

    /**
     * 语言 （en zh）
     */
    private String language;

    /**
     * 主题（0 1 2）
     */
    private String theme;

    private String account;

    private String password;

    private String authCode;

    public static final String RESPONSE_TYPE = "code";

    @Override
    public String uri() {
        return "/authorize/code";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(clientId) || StringUtils.isBlank(redirectUri) || StringUtils.isBlank(responseType)){
            return false;
        }
        return super.paramValid();
    }
}
