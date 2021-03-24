package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/30 20:05
 * @description
 */
@Data
public class AccessTokenRequest extends BaseRequest {

    private static final long serialVersionUID = 1274144137831492771L;

    private String client_id;

    private String client_secret;

    private String redirect_uri;

    private String grant_type;

    private String code;

    private String refresh_token;

    private String state;

    private String scopes;

    public static final String GrantType_AuthCode = "authorization_code";
    public static final String GrantType_RefreshToken = "refresh_token";

    @Override
    public String uri() {
        return "/access_token";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(client_id) || StringUtils.isBlank(client_secret)
                || StringUtils.isBlank(grant_type) ){
            return false;
        }
        return super.paramValid();
    }

    public Map<String,String> getParamsMap() {
        Map<String, String> paramsMap = new HashMap();
        paramsMap.put("client_id",client_id);
        paramsMap.put("client_secret",client_secret);
        paramsMap.put("redirect_uri",redirect_uri);
        paramsMap.put("grant_type",grant_type);
        paramsMap.put("code",code);
        paramsMap.put("refresh_token",refresh_token);
        paramsMap.put("state",state);
        paramsMap.put("scopes",scopes);
        return paramsMap;
    }

}
