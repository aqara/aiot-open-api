package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.ResourceManager;
import com.lumi.opencloud.model.v1.request.ResourceHistoryQueryRequest;
import com.lumi.opencloud.model.v1.request.ResourceQueryInfo;
import com.lumi.opencloud.model.v1.request.ResourceSubscribeInfo;
import com.lumi.opencloud.model.v1.request.ResourceUpdateRequest;
import com.lumi.opencloud.model.v1.response.ResourceHistoryQueryResponse;
import com.lumi.opencloud.model.v1.response.ResourceQueryResponse;
import config.TestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author lvyl
 * @date 2019/7/17 20:22
 * @description
 */
public class ResourceTest {
    private static Logger log = LoggerFactory.getLogger(ResourceTest.class);

    private AiotConfig testV1Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, TestConfig.Token, CustomConfig.Lang, CustomConfig.DOMAIN_V1);
    }

    @Test
    public void query() {
        List<ResourceQueryInfo> infoList = new ArrayList<>();
        ResourceQueryInfo info = new ResourceQueryInfo();
        info.setDid(TestConfig.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg<List<ResourceQueryResponse>> responseMsg = ResourceManager.query(testV1Config(),infoList);
        log.info("resource query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryName() {
        List<ResourceQueryInfo> infoList = new ArrayList<>();
        ResourceQueryInfo info = new ResourceQueryInfo();
        info.setDid(TestConfig.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg<List<ResourceQueryResponse>> responseMsg = ResourceManager.queryName(testV1Config(),infoList);
        log.info("resource query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void update() {
        ResourceUpdateRequest request = new ResourceUpdateRequest();
        request.setDid(TestConfig.HubDid);
        Map<String,Object> attr = new HashMap<>();
        attr.put("corridor_light_status",1);
        request.setAttrs(attr);
        ResponseMsg responseMsg = ResourceManager.update(testV1Config(),request);
        log.info("resource update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void subscriber() {
        List<ResourceSubscribeInfo> infoList = new ArrayList<>();
        ResourceSubscribeInfo info = new ResourceSubscribeInfo();
        info.setDid(TestConfig.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg responseMsg = ResourceManager.subscriber(testV1Config(),infoList);
        log.info("resource subscriber responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unsubscriber() {
        List<ResourceSubscribeInfo> infoList = new ArrayList<>();
        ResourceSubscribeInfo info = new ResourceSubscribeInfo();
        info.setDid(TestConfig.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg responseMsg = ResourceManager.unsubscriber(testV1Config(),infoList);
        log.info("resource unsubscriber responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void historyQuery() {
        ResourceHistoryQueryRequest request = new ResourceHistoryQueryRequest();
        request.setDid(TestConfig.HubDid);
        request.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        request.setStartTime("1615451484000");
        ResponseMsg<ResourceHistoryQueryResponse> responseMsg = ResourceManager.historyQuery(testV1Config(),request);
        log.info("resource history query responseMsg:{}",responseMsg.toString());
    }
}
