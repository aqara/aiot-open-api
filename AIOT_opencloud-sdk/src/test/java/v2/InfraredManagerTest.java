package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v2.DeviceManager;
import com.lumi.opencloud.manager.v2.InfraredManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: yhy
 * @date: 2021/03/25 17:59
 */
public class InfraredManagerTest {

    private static Logger log = LoggerFactory.getLogger(DeviceTest.class);


    private AiotConfig testV2Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void categories() {
        ResponseMsg responseMsg = InfraredManager.categories(testV2Config());
        log.info("bindGet responseMsg:{}",responseMsg.toString());
    }
}
