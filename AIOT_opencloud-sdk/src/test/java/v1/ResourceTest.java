package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.ResourceManager;
import com.lumi.opencloud.model.v1.request.ResourceHistoryQueryRequest;
import com.lumi.opencloud.model.v1.request.ResourceQueryInfo;
import com.lumi.opencloud.model.v1.request.ResourceSubscribeInfo;
import com.lumi.opencloud.model.v1.request.ResourceUpdateRequest;
import com.lumi.opencloud.model.v1.response.ResourceHistoryQueryResponse;
import com.lumi.opencloud.model.v1.response.ResourceQueryResponse;
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

    private void setClient(){
        AiotConfig.setClientV1(TestConstants.Appid,TestConstants.Appkey,TestConstants.Token,TestConstants.Lang,TestConstants.DOMAIN_V1);
    }

    @Test
    public void query() {
        setClient();
        List<ResourceQueryInfo> infoList = new ArrayList<>();
        ResourceQueryInfo info = new ResourceQueryInfo();
        info.setDid(TestConstants.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        ResponseMsg<List<ResourceQueryResponse>> responseMsg = ResourceManager.query(infoList);
        log.info("resource query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void update() {
        setClient();
        ResourceUpdateRequest request = new ResourceUpdateRequest();
        request.setDid(TestConstants.HubDid);
        Map<String,Object> attr = new HashMap<>();
        attr.put("corridor_light_status",1);
        request.setAttrs(attr);
        ResponseMsg responseMsg = ResourceManager.update(request);
        log.info("resource update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void subscriber() {
        setClient();
        List<ResourceSubscribeInfo> infoList = new ArrayList<>();
        ResourceSubscribeInfo info = new ResourceSubscribeInfo();
        info.setDid(TestConstants.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg responseMsg = ResourceManager.subscriber(infoList);
        log.info("resource subscriber responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unsubscriber() {
        setClient();
        List<ResourceSubscribeInfo> infoList = new ArrayList<>();
        ResourceSubscribeInfo info = new ResourceSubscribeInfo();
        info.setDid(TestConstants.HubDid);
        info.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        infoList.add(info);
        ResponseMsg responseMsg = ResourceManager.unsubscriber(infoList);
        log.info("resource unsubscriber responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void historyQuery() {
        setClient();
        ResourceHistoryQueryRequest request = new ResourceHistoryQueryRequest();
        request.setDid(TestConstants.HubDid);
        request.setAttrs(Arrays.asList("brightness_level","corridor_light_status"));
        request.setStartTime("");
        ResponseMsg<ResourceHistoryQueryResponse> responseMsg = ResourceManager.historyQuery(request);
        log.info("resource history query responseMsg:{}",responseMsg.toString());
    }
}
