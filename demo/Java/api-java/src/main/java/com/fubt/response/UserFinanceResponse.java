package com.fubt.response;

import java.util.List;
import java.util.Map;

/**
 * @Description UserFinanceResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class UserFinanceResponse extends BaseResponse {

    private List<Map<String,Object>> data;

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
