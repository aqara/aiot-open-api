package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v1.DeviceManager;
import com.lumi.opencloud.model.v1.request.DeviceQueryRequest;
import com.lumi.opencloud.model.v1.request.DeviceUpdateRequest;
import com.lumi.opencloud.model.v1.response.DeviceQueryResponse;
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

    private void setClient(){
        AiotConfig.setClientV1(TestConstants.Appid,TestConstants.Appkey,TestConstants.Token,TestConstants.Lang,TestConstants.DOMAIN_V1);
    }

    @Test
    public void deviceQuery() {
        setClient();
        DeviceQueryRequest request = new DeviceQueryRequest();
        ResponseMsg<DeviceQueryResponse> responseMsg = DeviceManager.deviceQuery(request);
        log.info("device query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceUpdate() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.deviceUpdate(TestConstants.SubDid,"test");
        log.info("device update responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceConnect() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.deviceConnect(TestConstants.HubDid);
        log.info("device connect responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void deviceConnectStop() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.deviceConnectStop(TestConstants.HubDid);
        log.info("device connect stop responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void childQuery() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.childQuery(TestConstants.HubDid);
        log.info("device child query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unbindDev() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.unbindDev(TestConstants.SubDid,1);
        log.info("device unbind responseMsg:{}",responseMsg.toString());
    }
}
