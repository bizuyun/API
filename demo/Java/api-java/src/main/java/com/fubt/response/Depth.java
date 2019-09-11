package com.fubt.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description Depth
 * @auther: wangzh
 * @date: 20190906
 */
public class Depth {

    List<Map<String,Object>> buy;

    List<Map<String,Object>> sell;

    public List<Map<String, Object>> getBuy() {
        return buy;
    }

    public void setBuy(List<Map<String, Object>> buy) {
        this.buy = buy;
    }

    public List<Map<String, Object>> getSell() {
        return sell;
    }

    public void setSell(List<Map<String, Object>> sell) {
        this.sell = sell;
    }
}
