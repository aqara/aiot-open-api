package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v2.SceneManager;
import com.lumi.opencloud.model.ifttt.ActionContent;
import com.lumi.opencloud.model.v2.request.SceneCreateRequest;
import com.lumi.opencloud.model.v2.request.SceneTryRequest;
import com.lumi.opencloud.model.v2.request.SceneUpdateRequest;
import config.TestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 20:45
 * @description
 */
public class SceneTest {
    private static Logger log = LoggerFactory.getLogger(DeviceTest.class);

    private AiotConfig testV2Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void createScene() {
        SceneCreateRequest request = new SceneCreateRequest();
        List<ActionContent> actions = new ArrayList<>();
        ActionContent actionContent = new ActionContent();
        actionContent.setSubjectId(TestConfig.HubDid);
        actionContent.setActionDefinitionId("AD.lumi.gateway.open_corridor_light");
        actionContent.setModel("lumi.gateway.aqhm01");
        actions.add(actionContent);
        request.setActions(actions);
        ResponseMsg responseMsg = SceneManager.createScene(testV2Config(),request);
        log.info("ifttt scene create responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void updateScene() {
        SceneUpdateRequest request = new SceneUpdateRequest();
        ResponseMsg responseMsg = SceneManager.updateScene(testV2Config(),request);
        log.info("ifttt scene update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteScene() {
        ResponseMsg responseMsg = SceneManager.deleteScene(testV2Config(),"");
        log.info("ifttt scene delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void tryScene() {
        SceneTryRequest request = new SceneTryRequest();
        ResponseMsg responseMsg = SceneManager.tryScene(testV2Config(),request);
        log.info("ifttt scene try responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void runScene() {
        ResponseMsg responseMsg = SceneManager.runScene(testV2Config(),"");
        log.info("ifttt scene run responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryDetailScene() {
        ResponseMsg responseMsg = SceneManager.queryDetailScene(testV2Config(),"");
        log.info("ifttt scene query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void querySubjectScene() {
        ResponseMsg responseMsg = SceneManager.querySubjectScene(testV2Config(),"");
        log.info("ifttt scene subject query responseMsg:{}",responseMsg.toString());
    }

}
