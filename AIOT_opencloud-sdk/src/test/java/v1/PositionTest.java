package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.PositionManager;
import com.lumi.opencloud.model.v1.request.PositionQueryRequest;
import com.lumi.opencloud.model.v1.response.PositionQueryResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lvyl
 * @date 2019/7/17 20:19
 * @description
 */
public class PositionTest {
    private static Logger log = LoggerFactory.getLogger(PositionTest.class);

    private void setClient(){
        AiotConfig.setClientV1(TestConstants.Appid,TestConstants.Appkey,TestConstants.Token,TestConstants.Lang,TestConstants.DOMAIN_V1);
    }
    
    @Test
    public void positionQuery() {
        setClient();
        PositionQueryRequest request = new PositionQueryRequest();
        ResponseMsg<PositionQueryResponse> responseMsg = PositionManager.positionQuery(request);
        log.info("device query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionAdd() {
        setClient();
        ResponseMsg responseMsg = PositionManager.positionAdd("","","");
        log.info("position add responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionDelete() {
        setClient();
        ResponseMsg responseMsg = PositionManager.positionDelete("");
        log.info("position delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionUpdate() {
        setClient();
        ResponseMsg responseMsg = PositionManager.positionUpdate("","","");
        log.info("position update responseMsg:{}",responseMsg.toString());
    }
}
