package v2;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.common.TestConstants;
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

    private void setClient(){
        AiotConfig.setClientV2(TestConstants.Appid,TestConstants.Appkey,TestConstants.Lang,TestConstants.DOMAIN_V2);
    }

    @Test
    public void query() {
        setClient();
        List<PropertiesQueryInfo> queryList = new ArrayList<>();
        ResponseMsg responseMsg = PropertiesManager.query(queryList);
        log.info("properties query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void write() {
        setClient();
        PropertiesWriteRequest request = new PropertiesWriteRequest();
        request.setDid("lumi1.7811dc93a6d9");
        Map<String,Object> data = new HashMap<>();
        data.put("corridor_light_status",1);
        request.setData(data);
        ResponseMsg responseMsg = PropertiesManager.write(request);
        log.info("properties write responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void historyQuery() {
        setClient();
        List<String> properties = new ArrayList<>();
        ResourceHistoryQueryRequest request = new ResourceHistoryQueryRequest();
        request.setProperties(properties);
        ResponseMsg responseMsg = PropertiesManager.historyQuery(request);
        log.info("properties history query responseMsg:{}",responseMsg.toString());
    }
}
