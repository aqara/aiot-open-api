package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.manager.v2.PropertiesManager;
import com.lumi.opencloud.model.v2.request.PropertiesQueryInfo;
import com.lumi.opencloud.model.v2.request.PropertiesWriteRequest;
import com.lumi.opencloud.model.v2.request.ResourceHistoryQueryRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyl
 * @date 2019/7/17 20:45
 * @description
 */
public class PropertiesTest {
    private static Logger log = LoggerFactory.getLogger(PropertiesTest.class);

    private AiotConfig testV2Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, CustomConfig.Lang, CustomConfig.DOMAIN_V2);
    }

    @Test
    public void query() {
        List<PropertiesQueryInfo> queryList = new ArrayList<>();
        ResponseMsg responseMsg = PropertiesManager.query(testV2Config(),queryList);
        log.info("properties query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void write() {
        PropertiesWriteRequest request = new PropertiesWriteRequest();
        request.setDid("lumi1.7811dc93a6d9");
        Map<String,Object> data = new HashMap<>();
        data.put("corridor_light_status",1);
        request.setData(data);
        ResponseMsg responseMsg = PropertiesManager.write(testV2Config(),request);
        log.info("properties write responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void historyQuery() {
        List<String> properties = new ArrayList<>();
        ResourceHistoryQueryRequest request = new ResourceHistoryQueryRequest();
        request.setProperties(properties);
        ResponseMsg responseMsg = PropertiesManager.historyQuery(testV2Config(),request);
        log.info("properties history query responseMsg:{}",responseMsg.toString());
    }
}
