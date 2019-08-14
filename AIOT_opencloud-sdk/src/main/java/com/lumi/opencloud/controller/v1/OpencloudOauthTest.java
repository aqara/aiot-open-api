package com.lumi.opencloud.controller.v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.OauthManager;
import com.lumi.opencloud.model.v1.request.AccessTokenRequest;
import com.lumi.opencloud.model.v1.request.AuthorizeRequest;
import com.lumi.opencloud.model.v1.response.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvyl
 * @date 2019/7/31 10:34
 * @description
 */
@RestController
@RequestMapping(path = "/v1.0/open", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpencloudOauthTest {

    private static Logger log = LoggerFactory.getLogger(OpencloudOauthTest.class);

    @PostMapping("/authorize")
    public String authorize(@RequestBody AuthorizeRequest request) {
        AiotConfig.setDomain(TestConstants.DOMAIN_OAUTH);
        String location =OauthManager.authorize(request);

        log.info("authorize response:{}",location);
        return location;
    }

    @PostMapping("/access_token")
    public AccessTokenResponse accessToken(@RequestBody AccessTokenRequest request) {
        AiotConfig.setDomain(TestConstants.DOMAIN_OAUTH);
        AccessTokenResponse response =OauthManager.accessToken(request);

        log.info("accessToken response:{}",response.toString());
        return response;
    }
}
