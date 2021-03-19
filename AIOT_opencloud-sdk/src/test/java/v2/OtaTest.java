package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v2.OtaManager;
import com.lumi.opencloud.model.v2.request.OtaFirmwareUpgradeDetail;
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
public class OtaTest {
    private static Logger log = LoggerFactory.getLogger(OtaTest.class);

    private AiotConfig testV2Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void firmwareQuery() {
        ResponseMsg responseMsg = OtaManager.firmwareQuery(testV2Config(),TestConfig.model);
        log.info("firmware query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void firmwareUpgrade() {
        List<OtaFirmwareUpgradeDetail> data = new ArrayList<>();
        OtaFirmwareUpgradeDetail detail = new OtaFirmwareUpgradeDetail();
        detail.setDid(TestConfig.HubDid);
        detail.setFirmwareVersion("");
        data.add(detail);
        ResponseMsg responseMsg = OtaManager.firmwareUpgrade(testV2Config(),data);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void upgradeQuery() {
        List<String> dids = new ArrayList<>();
        dids.add(TestConfig.HubDid);
        ResponseMsg responseMsg = OtaManager.upgradeQuery(testV2Config(),dids);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());
    }
}
