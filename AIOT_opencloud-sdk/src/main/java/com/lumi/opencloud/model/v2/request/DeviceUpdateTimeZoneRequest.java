package com.lumi.opencloud.model.v2.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zzm
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class DeviceUpdateTimeZoneRequest extends BaseRequest {
    private static final Pattern pattern = Pattern.compile("^[+-]([0-9]|(1[0-2]))(\\.5)?$");

    private static final long serialVersionUID = -6137563735732272083L;
    /**
     * 设备id
     */
    private List<String> dids;

    /**
     * 绑定查询
     */
    private String timeZone;

    @Override
    public String uri() {
        return "/dev/timezone/update";
    }

    @Override
    public boolean paramValid() {
        if(CollectionUtils.isEmpty(dids)){
            return false;
        }
        if(!checkTimeZone(timeZone)){
            return false;
        }
        return super.paramValid();
    }

    @Override
    public Map<String,Object> requestMap() {
        Map<String, Object> paramsMap = new HashMap();
        paramsMap.put("dids",dids);
        paramsMap.put("timeZone",timeZone);
        return paramsMap;
    }

    public static boolean checkTimeZone(String timeZone) {
        Matcher matcher = pattern.matcher(timeZone);
        return matcher.matches();
    }
}
