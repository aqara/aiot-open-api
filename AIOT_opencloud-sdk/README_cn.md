# Lumi Aqara云云对接API SDK Java版本
[English](README.md) | [中文版](README_cn.md)

## 使用前需要做

1. 确认JDK8版本及以上

2. 在Aqara开放平台注册开发者账号，确定AppID、AppKey、设备地址(调用地址)这些值
各区域开放平台地址:
China: https://aiot-open-3rd.aqara.cn
USA: https://aiot-open-usa.aqara.com
Europe: https://open-ger.aqara.com
Korea: https://open-kr.aqara.com
Russia: https://open-ru.aqara.com

## 源码安装
1. 下载此工程代码到本地。
2. 解压源码包到您项目合适的位置。
3. 代码中引用对应模块代码，可参考示例。

## 引用jar包安装
1. 将源码打成jar包。
2. 在您的工程中添加jar包到合适位置。

## 使用说明
SDK中提供了两套接口，您可以根据需求任意选择一种，但是两套接口不能混用。如果有其他需求，您也可以联系我们，我们会及时更新。
1.使用Aqara Home账号体系(V1.0系列接口)
2.不使用Aqara Home账号体系(V2.0系列接口)
### 直接调用封装类方法
#### 定义配置类
新建配置类，将所需参数填好。
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

#### 在项目中直接调用Manager中的静态方法。
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

## 常见问题
### 关于access_token

token是访问v1.0系列接口的用户凭证，请调用方保存好，并且注意在过期后需要通过refresh_token
重新获取。

### 关于refreshToken接口

注意:refreshToken接口会返回一个新的access_token，即使旧的token还未过期。

若在未过期前调用了refreshToken，即使旧的access_token未过期也无效了。

### 每次调用api之前，是否需要获取token或者刷新token？

不需要，只要access_token未过期就可以一直使用，需要调用方保存好。

### 调用某个接口时，如果token已经过期，需要手动调用refresh-token接口？

需要，调用方需要检查token是否过期。如果过期需要重新获取。


## 技术支持

你可以通过以下方式获得Aqara开发者技术支持：
联系方式：
- Email:aiot-support@aqara.com
