package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/30 20:05
 * @description
 */
public class AuthorizeRequest extends BaseRequest {

    private static final long serialVersionUID = 7623426880956440718L;

    private String client_id;

    /**
     * response_type = code
     */
    private String response_type;

    private String redirect_uri;

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

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final String RESPONSE_TYPE = "code";

    @Override
    public String uri() {
        return "/authorize";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(client_id) || StringUtils.isBlank(redirect_uri) || StringUtils.isBlank(response_type)){
            return false;
        }
        return super.paramValid();
    }

    public Map<String,String> getParamsMap() {
        Map<String, String> paramsMap = new HashMap();
        paramsMap.put("client_id",client_id);
        paramsMap.put("response_type",response_type);
        paramsMap.put("redirect_uri",redirect_uri);
        paramsMap.put("state",state);
        paramsMap.put("language",language);
        paramsMap.put("theme",theme);
        return paramsMap;
    }

    public Map<String,String> getBodyMap() {
        Map<String, String> paramsMap = new HashMap();
        paramsMap.put("account",account);
        paramsMap.put("password",password);
        return paramsMap;
    }
}
