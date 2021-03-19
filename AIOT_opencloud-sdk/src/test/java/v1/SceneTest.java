package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.SceneManager;
import com.lumi.opencloud.model.v1.request.ActionContentRequest;
import com.lumi.opencloud.model.v1.request.SceneCreateRequest;
import com.lumi.opencloud.model.v1.request.SceneListQueryRequest;
import com.lumi.opencloud.model.v1.response.SceneCreateResponse;
import com.lumi.opencloud.model.v1.response.SceneListQueryResponse;
import com.lumi.opencloud.model.v1.response.SceneQueryDetailResponse;
import config.TestConfig;
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

    private AiotConfig testV1Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, TestConfig.Token, CustomConfig.Lang, CustomConfig.DOMAIN_V1);
    }

    @Test
    public void querySceneList() {
        SceneListQueryRequest request = new SceneListQueryRequest();
        ResponseMsg<SceneListQueryResponse> responseMsg = SceneManager.querySceneList(testV1Config(),request);
        log.info("scene query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void querySceneDetail() {
        ResponseMsg<SceneQueryDetailResponse> responseMsg = SceneManager.querySceneDetail(testV1Config(),"AL.589423173984845824");
        log.info("scene query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void createScene() {
        SceneCreateRequest request = new SceneCreateRequest();
        request.setName("test1");
        request.setPositionId("real1.526842808154193920");
        List<ActionContentRequest> contentList = new ArrayList<>();
        ActionContentRequest content = new ActionContentRequest();
        content.setDid("lumi.158d0002395c04");
        content.setAction("AD.lumi.gateway.toggle_corridor_light");
        contentList.add(content);
        request.setContent(contentList);
        ResponseMsg<SceneCreateResponse> responseMsg = SceneManager.createScene(testV1Config(),request);
        log.info("scene add responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteScene() {
        ResponseMsg responseMsg = SceneManager.deleteScene(testV1Config(),"AL.601429121547620352");
        log.info("scene delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void runScene() {
        ResponseMsg responseMsg = SceneManager.runScene(testV1Config(),"AL.601428747222765568");
        log.info("scene run responseMsg:{}",responseMsg.toString());
    }
}
