package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.OauthManager;
import com.lumi.opencloud.model.v1.request.AccessTokenRequest;
import com.lumi.opencloud.model.v1.request.AuthorizeRequest;
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
        request.setClient_id("08821a12896631f8053610a1");
        request.setRedirect_uri("www.aqara.com");
        request.setResponse_type("code");
        request.setState("aqara");

        request.setAccount("ifeng@aqara.com");
        request.setPassword("king7777");
        OauthManager.authorize(CustomConfig.DOMAIN,request);
    }

    @Test
    public void accessToken() {
        AccessTokenRequest request = new AccessTokenRequest();
        request.setClient_id("4d6382d971361476664c465a");
        request.setClient_secret("S0X1TUwz12uFlmDEwWcyx27kASRC91eI");
        request.setRedirect_uri("www.aqara.com");
        request.setGrant_type(AccessTokenRequest.GrantType_AuthCode);
        request.setCode("ba70e25853b0c3cddbc810e24c50024f");
        request.setState("aqara");
        OauthManager.accessToken(CustomConfig.DOMAIN,request);
    }
}
