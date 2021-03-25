package com.lumi.opencloud.model.v1.response;

import lombok.Data;

/**
 * @author lvyl
 * @date 2019/7/30 20:05
 * @description
 */
@Data
public class AccessTokenResponse {

    private static final long serialVersionUID = 1274144137831492771L;

    private String accessToken;

    private String refreshToken;

    private String openId;

    private String state;

    private String tokenType;

    private String expiresIn;

}
