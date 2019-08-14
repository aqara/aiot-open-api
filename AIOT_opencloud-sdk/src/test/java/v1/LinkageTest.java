package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.LinkageManager;
import com.lumi.opencloud.model.ifttt.IftttParam;
import com.lumi.opencloud.model.v1.request.ActionContentRequest;
import com.lumi.opencloud.model.v1.request.IftttCreateRequest;
import com.lumi.opencloud.model.v1.request.IftttListQueryRequest;
import com.lumi.opencloud.model.v1.request.TriggerContentRequest;
import com.lumi.opencloud.model.v1.response.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyl
 * @date 2019/7/17 20:14
 * @description
 */
public class LinkageTest {
    private static Logger log = LoggerFactory.getLogger(LinkageTest.class);

    private void setClient(){
        AiotConfig.setClientV1(TestConstants.Appid,TestConstants.Appkey,TestConstants.Token,TestConstants.Lang,TestConstants.DOMAIN_V1);
    }

    @Test
    public void triggerQuery() {
        setClient();
        List<String> models = new ArrayList<>();
        models.add(TestConstants.model);
        models.add(TestConstants.model2);
        ResponseMsg<List<IftttTriggerQueryResponse>> responseMsg = LinkageManager.triggerQuery(models);
        log.info("trigger query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void actionQuery() {
        setClient();
        List<String> models = new ArrayList<>();
        models.add(TestConstants.model);
        models.add(TestConstants.model2);
        ResponseMsg<List<IftttActionQueryResponse>> responseMsg = LinkageManager.actionQuery(models);
        log.info("trigger query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryIfttt() {
        setClient();
        IftttListQueryRequest request = new IftttListQueryRequest();
        ResponseMsg<IftttDetailQueryResponse> responseMsg = LinkageManager.queryIfttt(request);
        log.info("ifttt query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void queryIftttDetail() {
        setClient();
        ResponseMsg<IftttDetailQueryResponse> responseMsg = LinkageManager.queryIftttDetail("L.601420611007008768");
        log.info("ifttt query detail responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void createIfttt() {
        setClient();
        IftttCreateRequest request = new IftttCreateRequest();
        request.setName("test");
        request.setPositionId("real1.526842808154193920");
        request.setConditionRelation(0);
        List<TriggerContentRequest> triggerList = new ArrayList<>();
        TriggerContentRequest trigger = new TriggerContentRequest();
        trigger.setDid("lumi.158d00023874b1");
        trigger.setTrigger("TD.lumi.weather.temp_less_than_instant");
        List<IftttParam> params = new ArrayList<>();
        IftttParam param = new IftttParam();
        param.setParamId("PD.temp");
        param.setValue("1000");
        param.setParamUnit("°C");
        params.add(param);
        trigger.setParams(params);
        triggerList.add(trigger);
        request.setConditions(triggerList);

        List<ActionContentRequest> actionList = new ArrayList<>();
        ActionContentRequest action = new ActionContentRequest();
        action.setAction("AD.lumi.gateway.close_corridor_light");
        action.setDid("lumi.158d0002395c04");
        actionList.add(action);
        request.setActions(actionList);
        ResponseMsg<IftttListQueryResponse> responseMsg = LinkageManager.createIfttt(request);
        log.info("ifttt add responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deleteIfttt() {
        setClient();
        ResponseMsg responseMsg = LinkageManager.deleteIfttt("L.601420611007008768");
        log.info("ifttt delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void enableIfttt() {
        setClient();
        ResponseMsg responseMsg = LinkageManager.enableIfttt("L.601423958355202048",0);
        log.info("ifttt enable responseMsg:{}",responseMsg.toString());
    }
}
