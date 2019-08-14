package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v2.DeviceManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lvyl
 * @date 2019/7/15 15:23
 * @description
 */
public class DeviceTest {
    private static Logger log = LoggerFactory.getLogger(DeviceTest.class);

    private void setClient(){
        AiotConfig.setClientV2(TestConstants.Appid,TestConstants.Appkey,TestConstants.Lang,TestConstants.DOMAIN_V2);
    }

    @Test
    public void bindGet() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.bindGet();
        log.info("bindGet responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void bindQuery() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.bindQuery("","");
        log.info("bind query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void childQuery() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.childQuery(TestConstants.HubDid);
        log.info("child query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void connectSubdeviceStart() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStart(TestConstants.HubDid,"");
        log.info("dev connect subdevice start responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void connectSubdeviceStop() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStop(TestConstants.HubDid);
        log.info("dev connect subdevice stop responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unbindDev() {
        setClient();
        ResponseMsg responseMsg = DeviceManager.unbindDev(TestConstants.SubDid,0);
        log.info("dev unbind responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void detailQuery() {
        setClient();
        List<String> dids = new ArrayList<>();
        dids.add(TestConstants.HubDid);
        ResponseMsg responseMsg = DeviceManager.detailQuery(dids);
        log.info("dev query detail responseMsg:{}",responseMsg.toString());
    }
}
