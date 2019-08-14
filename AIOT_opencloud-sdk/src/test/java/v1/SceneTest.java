package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.SceneManager;
import com.lumi.opencloud.model.v1.request.ActionContentRequest;
import com.lumi.opencloud.model.v1.request.SceneCreateRequest;
import com.lumi.opencloud.model.v1.request.SceneListQueryRequest;
import com.lumi.opencloud.model.v1.response.SceneCreateResponse;
import com.lumi.opencloud.model.v1.response.SceneListQueryResponse;
import com.lumi.opencloud.model.v1.response.SceneQueryDetailResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 20:36
 * @description
 */
public class SceneTest {
    private static Logger log = LoggerFactory.getLogger(SceneTest.class);

    private void setClient(){
        AiotConfig.setClientV1(TestConstants.Appid,TestConstants.Appkey,TestConstants.Token,TestConstants.Lang,TestConstants.DOMAIN_V1);
    }

    @Test
    public void querySceneList() {
        setClient();
        SceneListQueryRequest request = new SceneListQueryRequest();
        ResponseMsg<SceneListQueryResponse> responseMsg = SceneManager.querySceneList(request);
        log.info("scene query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void querySceneDetail() {
        setClient();
        ResponseMsg<SceneQueryDetailResponse> responseMsg = SceneManager.querySceneDetail("AL.589423173984845824");
        log.info("scene query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void createScene() {
        setClient();
        SceneCreateRequest request = new SceneCreateRequest();
        request.setName("test1");
        request.setPositionId("real1.526842808154193920");
        List<ActionContentRequest> contentList = new ArrayList<>();
        ActionContentRequest content = new ActionContentRequest();
        content.setDid("lumi.158d0002395c04");
        content.setAction("AD.lumi.gateway.toggle_corridor_light");
        contentList.add(content);
        request.setContent(contentList);
        ResponseMsg<SceneCreateResponse> responseMsg = SceneManager.createScene(request);
        log.info("scene add responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.deleteScene("AL.601429121547620352");
        log.info("scene delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void runScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.runScene("AL.601428747222765568");
        log.info("scene run responseMsg:{}",responseMsg.toString());
    }
}
