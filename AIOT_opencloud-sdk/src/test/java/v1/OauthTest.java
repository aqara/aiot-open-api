package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.OauthManager;
import com.lumi.opencloud.model.v1.request.AccessTokenRequest;
import com.lumi.opencloud.model.v1.request.AuthorizeRequest;
import com.lumi.opencloud.util.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lvyl
 * @date 2019/7/30 22:09
 * @description
 */
public class OauthTest {

    private static Logger log = LoggerFactory.getLogger(OauthTest.class);

    @Test
    public void authorize() {
        AuthorizeRequest request = new AuthorizeRequest();
        request.setClientId(CustomConfig.Appid);
        request.setRedirectUri("www.aqara.com");
        request.setResponseType("code");
        request.setState("aqara");

        request.setAccount("");
        request.setPassword("");
        OauthManager.authorize(CustomConfig.DOMAIN,request);
    }

    @Test
    public void accessToken() {
        AccessTokenRequest request = new AccessTokenRequest();
        request.setClient_id(CustomConfig.Appid);
        request.setClient_secret(CustomConfig.Appkey);
        request.setRedirect_uri("www.aqara.com");
        request.setGrant_type(AccessTokenRequest.GrantType_AuthCode);
        request.setCode("");
        request.setState("aqara");
        OauthManager.accessToken(CustomConfig.DOMAIN,request);
    }
}
