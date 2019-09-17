package com.fubt.response;

import java.util.List;

/**
 * @Description DepthResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class DepthResponse extends BaseResponse{

    private List<DepthPo> buy;

    private List<DepthPo> sell;

    public List<DepthPo> getBuy() {
        return buy;
    }

    public void setBuy(List<DepthPo> buy) {
        this.buy = buy;
    }

    public List<DepthPo> getSell() {
        return sell;
    }

    public void setSell(List<DepthPo> sell) {
        this.sell = sell;
    }
}
