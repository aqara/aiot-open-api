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

    private String clientId;

    private String clientSecret;

    private String redirectUri;

    private String grantType;

    private String code;

    private String refreshToken;

    private String state;

    private String scopes;

    public static final String GrantType_AuthCode = "authorization_code";
    public static final String GrantType_RefreshToken = "refresh_token";

    @Override
    public String uri() {
        return "/token";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(clientId) || StringUtils.isBlank(clientSecret)
                || StringUtils.isBlank(grantType) ){
            return false;
        }
        return super.paramValid();
    }

    public Map<String,String> getParamsMap() {
        Map<String, String> paramsMap = new HashMap();
        paramsMap.put("clientId",clientId);
        paramsMap.put("clientSecret",clientSecret);
        paramsMap.put("redirectUri",redirectUri);
        paramsMap.put("grantType",grantType);
        paramsMap.put("authorizationCode",code);
        paramsMap.put("refreshToken",refreshToken);
        paramsMap.put("state",state);
        paramsMap.put("scopes",scopes);
        return paramsMap;
    }

}
