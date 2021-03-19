package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v2.DeviceManager;
import config.TestConfig;
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

    private AiotConfig testV2Config(){
       return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void bindGet() {
        ResponseMsg responseMsg = DeviceManager.bindGet(testV2Config());
        log.info("bindGet responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void bindQuery() {
        ResponseMsg responseMsg = DeviceManager.bindQuery(testV2Config(),"","");
        log.info("bind query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void childQuery() {
        ResponseMsg responseMsg = DeviceManager.childQuery(testV2Config(),TestConfig.HubDid);
        log.info("child query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void connectSubdeviceStart() {
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStart(testV2Config(),TestConfig.HubDid,"");
        log.info("dev connect subdevice start responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void connectSubdeviceStop() {
        ResponseMsg responseMsg = DeviceManager.connectSubdeviceStop(testV2Config(),TestConfig.HubDid);
        log.info("dev connect subdevice stop responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void unbindDev() {
        ResponseMsg responseMsg = DeviceManager.unbindDev(testV2Config(),TestConfig.SubDid,0);
        log.info("dev unbind responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void detailQuery() {
        List<String> dids = new ArrayList<>();
        dids.add(TestConfig.HubDid);
        ResponseMsg responseMsg = DeviceManager.detailQuery(testV2Config(),dids);
        log.info("dev query detail responseMsg:{}",responseMsg.toString());
    }
}
