package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v2.LinkageManager;
import com.lumi.opencloud.model.ifttt.ActionContent;
import com.lumi.opencloud.model.ifttt.IftttParam;
import com.lumi.opencloud.model.ifttt.TriggerContent;
import com.lumi.opencloud.model.v2.request.IftttCreateRequest;
import com.lumi.opencloud.model.v2.request.IftttUpdateRequest;
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
public class LinkageTest {
    private static Logger log = LoggerFactory.getLogger(LinkageTest.class);

    private AiotConfig testV2Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void triggerDefinitionQuery() {
        List<String> models = new ArrayList<>();
        models.add(TestConfig.model);
        ResponseMsg responseMsg = LinkageManager.triggerDefinitionQuery(testV2Config(),models);
        log.info("ifttt trigger definition query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void actionDefinitionQuery() {
        List<String> models = new ArrayList<>();
        models.add(TestConfig.model);
        ResponseMsg responseMsg = LinkageManager.actionDefinitionQuery(testV2Config(),models);
        log.info("ifttt action definition query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void createIfttt() {
        IftttCreateRequest request = new IftttCreateRequest();
        request.setRelation(0);
        List<TriggerContent> conditions = new ArrayList<>();
        TriggerContent triggerContent = new TriggerContent();
        triggerContent.setSubjectId("");
        triggerContent.setModel("");
        triggerContent.setTriggerDefinitionId("");
        List<IftttParam> params = new ArrayList<>();
        IftttParam param = new IftttParam();
        param.setParamId("");
        param.setValue("");
        params.add(param);
        triggerContent.setParams(params);
        conditions.add(triggerContent);
        request.setConditions(conditions);

        List<ActionContent> actions = new ArrayList<>();
        ActionContent actionContent = new ActionContent();
        actionContent.setActionDefinitionId("");
        actionContent.setSubjectId("");
        actionContent.setModel("");
        actions.add(actionContent);
        request.setActions(actions);
        ResponseMsg responseMsg = LinkageManager.createIfttt(testV2Config(),request);
        log.info("ifttt create responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void updateIfttt() {
        IftttUpdateRequest request = new IftttUpdateRequest();
        ResponseMsg responseMsg = LinkageManager.updateIfttt(testV2Config(),request);
        log.info("ifttt update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteIfttt() {
        ResponseMsg responseMsg = LinkageManager.deleteIfttt(testV2Config(),"L.601479650938064896");
        log.info("ifttt delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void enableIfttt() {
        ResponseMsg responseMsg = LinkageManager.enableIfttt(testV2Config(),"L.601479650938064896",0);
        log.info("ifttt enable responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryDetail() {
        ResponseMsg responseMsg = LinkageManager.queryDetail(testV2Config(),"L.601479650938064896");
        log.info("ifttt query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void subjectQuery() {
        ResponseMsg responseMsg = LinkageManager.subjectQuery(testV2Config(),"L.601479650938064896");
        log.info("ifttt subject query responseMsg:{}",responseMsg.toString());
    }
}
