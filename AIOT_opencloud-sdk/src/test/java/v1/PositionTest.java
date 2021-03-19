package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.PositionManager;
import com.lumi.opencloud.model.v1.request.PositionQueryRequest;
import com.lumi.opencloud.model.v1.response.PositionQueryResponse;
import config.TestConfig;
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

    private AiotConfig testV1Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, TestConfig.Token, CustomConfig.Lang, CustomConfig.DOMAIN_V1);
    }
    
    @Test
    public void positionQuery() {
        PositionQueryRequest request = new PositionQueryRequest();
        ResponseMsg<PositionQueryResponse> responseMsg = PositionManager.positionQuery(testV1Config(),request);
        log.info("device query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionAdd() {
        ResponseMsg responseMsg = PositionManager.positionAdd(testV1Config(),"","","");
        log.info("position add responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionDelete() {
        ResponseMsg responseMsg = PositionManager.positionDelete(testV1Config(),"");
        log.info("position delete responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void positionUpdate() {
        ResponseMsg responseMsg = PositionManager.positionUpdate(testV1Config(),"","","");
        log.info("position update responseMsg:{}",responseMsg.toString());
    }
}
