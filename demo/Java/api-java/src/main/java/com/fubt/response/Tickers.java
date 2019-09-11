package com.fubt.response;

import java.math.BigDecimal;

/**
 * @Description 全部交易对的信息
 * @auther: wangzh
 * @date: 20190906
 */
public class Tickers {

    private String tradeName;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal last;
    private BigDecimal open;
    private BigDecimal chg;
    private BigDecimal vol24hour;

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getChg() {
        return chg;
    }

    public void setChg(BigDecimal chg) {
        this.chg = chg;
    }

    public BigDecimal getVol24hour() {
        return vol24hour;
    }

    public void setVol24hour(BigDecimal vol24hour) {
        this.vol24hour = vol24hour;
    }
}
