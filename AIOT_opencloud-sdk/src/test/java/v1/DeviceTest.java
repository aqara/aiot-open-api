package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v1.DeviceManager;
import com.lumi.opencloud.model.v1.request.DeviceQueryRequest;
import com.lumi.opencloud.model.v1.response.DeviceQueryResponse;
import config.TestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author lvyl
 * @date 2019/7/15 15:23
 * @description
 */
public class DeviceTest {
    private static Logger log = LoggerFactory.getLogger(DeviceTest.class);

    private AiotConfig testV1Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, TestConfig.Token, CustomConfig.Lang, CustomConfig.DOMAIN_V1);
    }

    @Test
    public void deviceQuery() {
        DeviceQueryRequest request = new DeviceQueryRequest();
        ResponseMsg<DeviceQueryResponse> responseMsg = DeviceManager.deviceQuery(testV1Config(),request);
        log.info("device query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceUpdate() {
        ResponseMsg responseMsg = DeviceManager.deviceUpdate(testV1Config(),TestConfig.SubDid,"test");
        log.info("device update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceConnect() {
        ResponseMsg responseMsg = DeviceManager.deviceConnect(testV1Config(),TestConfig.HubDid);
        log.info("device connect responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceConnectStop() {
        ResponseMsg responseMsg = DeviceManager.deviceConnectStop(testV1Config(),TestConfig.HubDid);
        log.info("device connect stop responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void childQuery() {
        ResponseMsg responseMsg = DeviceManager.childQuery(testV1Config(),TestConfig.HubDid);
        log.info("device child query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unbindDev() {
        ResponseMsg responseMsg = DeviceManager.unbindDev(testV1Config(),TestConfig.SubDid,1);
        log.info("device unbind responseMsg:{}",responseMsg.toString());
    }
}
