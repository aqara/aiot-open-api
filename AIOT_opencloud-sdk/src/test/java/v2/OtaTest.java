package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
import com.lumi.opencloud.manager.v2.OtaManager;
import com.lumi.opencloud.model.v2.request.OtaFirmwareUpgradeDetail;
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

    private void setClient(){
        AiotConfig.setClientV2(TestConstants.Appid,TestConstants.Appkey,TestConstants.Lang,TestConstants.DOMAIN_V2);
    }

    @Test
    public void firmwareQuery() {
        setClient();
        ResponseMsg responseMsg = OtaManager.firmwareQuery(TestConstants.model);
        log.info("firmware query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void firmwareUpgrade() {
        setClient();
        List<OtaFirmwareUpgradeDetail> data = new ArrayList<>();
        OtaFirmwareUpgradeDetail detail = new OtaFirmwareUpgradeDetail();
        detail.setDid(TestConstants.HubDid);
        detail.setFirmwareVersion("");
        data.add(detail);
        ResponseMsg responseMsg = OtaManager.firmwareUpgrade(data);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void upgradeQuery() {
        setClient();
        List<String> dids = new ArrayList<>();
        dids.add(TestConstants.HubDid);
        ResponseMsg responseMsg = OtaManager.upgradeQuery(dids);
        log.info("firmware upgrade responseMsg:{}",responseMsg.toString());
    }
}
