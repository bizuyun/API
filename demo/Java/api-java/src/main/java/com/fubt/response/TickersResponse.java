package com.fubt.response;

import java.util.List;

/**
 * @Description TickersResponse
 * @auther: wangzh
 * @date: 20190906
 */
public class TickersResponse extends BaseResponse {

    private List<Tickers> data;

    public List<Tickers> getData() {
        return data;
    }

    public void setData(List<Tickers> data) {
        this.data = data;
    }
}
