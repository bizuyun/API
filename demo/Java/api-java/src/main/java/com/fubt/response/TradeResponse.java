package com.fubt.response;

import java.util.List;

/**
 * @Description TradeResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class TradeResponse extends BaseResponse{

    private List<TradePo> data;

    public List<TradePo> getData() {
        return data;
    }

    public void setData(List<TradePo> data) {
        this.data = data;
    }
}
