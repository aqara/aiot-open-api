# Lumi Aqara Cloud-Cloud API SDK for JAVA

[English](README.md) | [中文版](README_cn.md)

## Introduction

Lumi Aqara Open Cloud API SDK for JAVA

## Preparation

* Confirm JDK8 version and above

* Register a developer account on the Aqara Open Cloud platform and determine the values of AppID, AppKey, Endpoint (call address)
Region Endpoint:
China: https://aiot-open-3rd.aqara.cn
USA: https://aiot-open-usa.aqara.com
Europe: https://open-ger.aqara.com
Korea: https://open-kr.aqara.com
Russia: https://open-ru.aqara.com

## Source installation
1. Download the source code compression package.
2. Unzip the source code package to a suitable location for your project.
3. For the reference of the corresponding module code in the code, see the example.

## Reference jar package installation
1. Compile the source code into a jar package.
2. Add the jar package to the appropriate location in your code

## Instructions for use
There are two sets of interfaces in the SDK. You can choose any one according to your needs, but the two sets of interfaces cannot be mixed. If you have other requirements, you can also contact us, we will update in time.
1. Use the Aqara Home account system (v1.0 series interface).
2. Do not use the Aqara Home account system (v2.0 series interface).

### Calling class methods directly
#### Fill configuration class
Create a new configuration class and fill in the required parameters.
```java
    public class AiotConfig {
        
            /**
             * application ID(get from aqara opencloud)
             */
            private String appId;
        
            /**
             * application key(get from aqara opencloud)
             */
            private String appKey;
        
            /**
             *
             * request domain of Aqara open cloud
             *      China: https://aiot-open-3rd.aqara.cn
             *      USA: https://aiot-open-usa.aqara.com
             *      Europe:https://open-ger.aqara.com
             *      Korea: https://open-kr.aqara.com
             *      Russia: https://open-ru.aqara.com
             *
             */
            private String domain;
        
            /**
             * language
             */
            private String lang;
        
            /**
             * access token
             */
            private String accessToken;
        
            /**
             * v1.0
             * @param appId
             * @param appKey
             * @param accessToken
             * @param lang
             * @param domain
             */
            public AiotConfig(String appId, String appKey, String accessToken, String lang, String domain){
                this.appId = appId;
                this.appKey = appKey;
                this.accessToken = accessToken;
                this.lang = lang;
                this.domain = domain;
            }
        
            /**
             * v2.0
             * @param appId
             * @param appKey
             * @param lang
             * @param domain
             */
            public AiotConfig(String appId,String appKey,String lang,String domain){
                this.appId = appId;
                this.appKey = appKey;
                this.lang = lang;
                this.domain = domain;
            }
    }
```

#### Calling static methods in manager directly in a project.
```java
    public class PositionManager extends CommonRequest {
        
            private static Logger log = LoggerFactory.getLogger(PositionManager.class);
        
            /**
             * 	查询位置
             *  Query position
             * @return ResponseMsg
             */
            public static ResponseMsg positionQuery(AiotConfig aiotConfig,PositionQueryRequest request) {
                try {
                    String domain = aiotConfig.getDomain() + request.uri();
                    String result = PooledHttpClientUtils.doGet(domain, constructHeaderV1(aiotConfig),request.requestMap());
                    log.info("positionQuery result:{},request:{}", result,JSON.toJSONString(request));
        
                    ResponseMsg<PositionQueryResponse> responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
                    return responseMsg;
                } catch (Exception e) {
                    log.error("positionQuery error:", e);
                }
        
                return null;
            }
        
            /**
             * 	创建位置
             *  Create position
             * @return ResponseMsg
             */
            public static ResponseMsg positionAdd(AiotConfig aiotConfig,String positionName,String parentPositionId,String description) {
                try {
                    PositionAddRequest request = new PositionAddRequest();
                    request.setPositionName(positionName);
                    request.setParentPositionId(parentPositionId);
                    request.setDescription(description);
                    String domain = aiotConfig.getDomain() + request.uri();
                    String result = PooledHttpClientUtils.doPost(domain, constructHeaderV1(aiotConfig), JSON.toJSONString(request));
                    log.info("positionAdd result:{},request:{}", result,JSON.toJSONString(request));
        
                    ResponseMsg responseMsg = JSONObject.parseObject(result,ResponseMsg.class);
                    return responseMsg;
                } catch (Exception e) {
                    log.error("positionAdd error:", e);
                }
        
                return null;
            }
    }
```


## FAQ

### About access_token
Token is the user's certificate for accessing v1.0 series interfaces. Please save it and pay attention to refresh after access_token expired.Get it again.

### About access_token
> **Note**: The refreshToken interface will return a new access_token, even if the old token has not expired.

If refreshToken is called before the expiration date, even the old access_token has not expired and is invalid.

### Before each API call, do you need to get or refresh the token?

No,the access_token can be used all the time without expiration, which needs to be saved by the caller.

### When calling an interface, if the token has expired, do I need to manually call the refresh-token interface?

Yes, the caller needs to check whether the token has expired. If it is out of date, it needs to be retrieved.


## Support

You can get support from Aqara with the following methods:
Contact information:
- Email:aiot-support@aqara.com

