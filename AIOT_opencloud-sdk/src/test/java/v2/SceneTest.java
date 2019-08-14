package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v2.SceneManager;
import com.lumi.opencloud.model.ifttt.ActionContent;
import com.lumi.opencloud.model.v2.request.SceneCreateRequest;
import com.lumi.opencloud.model.v2.request.SceneTryRequest;
import com.lumi.opencloud.model.v2.request.SceneUpdateRequest;
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

    private void setClient(){
        AiotConfig.setClientV2(TestConstants.Appid,TestConstants.Appkey,TestConstants.Lang,TestConstants.DOMAIN_V2);
    }

    @Test
    public void createScene() {
        setClient();
        SceneCreateRequest request = new SceneCreateRequest();
        List<ActionContent> actions = new ArrayList<>();
        ActionContent actionContent = new ActionContent();
        actionContent.setSubjectId(TestConstants.HubDid);
        actionContent.setActionDefinitionId("AD.lumi.gateway.open_corridor_light");
        actionContent.setModel("lumi.gateway.aqhm01");
        actions.add(actionContent);
        request.setActions(actions);
        ResponseMsg responseMsg = SceneManager.createScene(request);
        log.info("ifttt scene create responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void updateScene() {
        setClient();
        SceneUpdateRequest request = new SceneUpdateRequest();
        ResponseMsg responseMsg = SceneManager.updateScene(request);
        log.info("ifttt scene update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.deleteScene("");
        log.info("ifttt scene delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void tryScene() {
        setClient();
        SceneTryRequest request = new SceneTryRequest();
        ResponseMsg responseMsg = SceneManager.tryScene(request);
        log.info("ifttt scene try responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void runScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.runScene("");
        log.info("ifttt scene run responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryDetailScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.queryDetailScene("");
        log.info("ifttt scene query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void querySubjectScene() {
        setClient();
        ResponseMsg responseMsg = SceneManager.querySubjectScene("");
        log.info("ifttt scene subject query responseMsg:{}",responseMsg.toString());
    }

}
