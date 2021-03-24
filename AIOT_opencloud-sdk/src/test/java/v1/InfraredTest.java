package v1;

import com.lumi.opencloud.common.AiotConfig;
import com.lumi.opencloud.common.CustomConfig;
import com.lumi.opencloud.common.ResponseMsg;
import com.lumi.opencloud.manager.v1.DeviceManager;
import com.lumi.opencloud.manager.v1.InfraredManager;
import com.lumi.opencloud.model.ir.request.IrControllerAddRequest;
import com.lumi.opencloud.model.ir.request.IrMatchDataRequest;
import com.lumi.opencloud.model.v1.request.DeviceQueryRequest;
import com.lumi.opencloud.model.v1.response.DeviceQueryResponse;
import config.TestConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : yifeng.jin
 * @Version : v1.0
 * @Description :IR Test
 * @Date : 2021/3/24 11:45 上午
 * Copyright (C) : Lumi United Technology Co., Ltd
 */
public class InfraredTest {

    private static Logger log = LoggerFactory.getLogger(InfraredTest.class);

    private AiotConfig testV1Config(){
        return new AiotConfig(CustomConfig.Appid, CustomConfig.Appkey, TestConfig.Token, CustomConfig.Lang, CustomConfig.DOMAIN_V1);
    }

    @Test
    public void categories() {
        ResponseMsg responseMsg = InfraredManager.categories(testV1Config());
        log.info("categories query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void categoryBrands() {
        ResponseMsg responseMsg = InfraredManager.categoryBrands(testV1Config(),"2");
        log.info("categoryBrands query responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void matchData() {
        IrMatchDataRequest request = new IrMatchDataRequest();
        request.setType(1);
        request.setCategoryId("2");
        request.setBrandId("17");
        ResponseMsg responseMsg = InfraredManager.matchData(testV1Config(),request);
        log.info("match data responseMsg:{}",responseMsg.toString());
    }

    @Test
    public void controllerAdd() {
        IrControllerAddRequest request = new IrControllerAddRequest();
        request.setBrandId(17);
        request.setCategoryId(2);
        request.setControllerId(932);
        request.setName("power");
        request.setParentId("lumi1.7811dc93a2e6");
        request.setPositionId("real2.605404584661200896");
        ResponseMsg responseMsg = InfraredManager.controllerAdd(testV1Config(),request);
        log.info("match data responseMsg:{}",responseMsg.toString());
    }

}