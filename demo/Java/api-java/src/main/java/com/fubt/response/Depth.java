package com.fubt.response;

import java.util.List;

/**
 * @Description Depth
 * @auther: wangzh
 * @date: 20190906
 */
public class Depth {

    List<DepthPo> buy;

    List<DepthPo> sell;

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
