package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.TestConstants;
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
        AiotConfig.setDomain(TestConstants.DOMAIN_OAUTH);
        AuthorizeRequest request = new AuthorizeRequest();
        request.setClient_id("xxx");
        request.setRedirect_uri("www.baidu.com");
        request.setResponse_type("code");
        request.setState("aqara");

        request.setAccount("xxx");
        request.setPassword("xxx");
        OauthManager.authorize(request);
    }

    @Test
    public void accessToken() {
        AiotConfig.setDomain(TestConstants.DOMAIN_OAUTH);
        AccessTokenRequest request = new AccessTokenRequest();
        request.setClient_id("xxx");
        request.setClient_secret("xxx");
        request.setRedirect_uri("www.baidu.com");
        request.setGrant_type(AccessTokenRequest.GrantType_AuthCode);
        request.setCode("xxx");
        request.setState("aqara");
        OauthManager.accessToken(request);
    }
}
