package com.fubt.response;

import java.util.Map;

/**
 * @Description 汇率折算response
 * @auther:
 * @date: 20190906
 */
public class ExchangeResponse extends BaseResponse{

    private Map<String,Object> data;//每个币种对应的法币 key为币种  value为法币值


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
