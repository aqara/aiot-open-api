package com.lumi.opencloud.model.v1.request;

import com.lumi.opencloud.common.BaseRequest;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Author: lumi
 * @Date: 2019/06/03
 * @Description:
 */
@Data
public class ResourceHistoryQueryRequest extends BaseRequest {

    private static final long serialVersionUID = -562054003261052371L;

    private String did;

    private List<String> attrs;

    private String startTime;

    private String endTime;

    private Integer pageNum;

    private Integer pageSize;

    @Override
    public String uri() {
        return "/resource/history/query";
    }

    @Override
    public boolean paramValid() {
        if(StringUtils.isBlank(did) || CollectionUtils.isEmpty(attrs)){
            return false;
        }
        return super.paramValid();
    }
}
