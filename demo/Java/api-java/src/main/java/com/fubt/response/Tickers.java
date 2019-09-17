package com.fubt.response;


/**
 * @Description 全部交易对的信息
 * @auther: wangzh
 * @date: 20190906
 */
public class Tickers {
    /**
     * 交易对名称
     */
    private String tradeName;
    /**
     *买一价格
     */
    private Number buy;
    /**
     *卖一价格
     */
    private Number sell;
    /**
     * 最高价
     */
    private Number high;
    /**
     * 最低价
     */
    private Number low;
    /**
     * 最新价
     */
    private Number last;
    /**
     * 开盘价
     */
    private Number open;
    /**
     * 涨跌
     */
    private Number chg;
    /**
     * 24小时成交量
     */
    private Number vol24hour;

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Number getBuy() {
        return buy;
    }

    public void setBuy(Number buy) {
        this.buy = buy;
    }

    public Number getSell() {
        return sell;
    }

    public void setSell(Number sell) {
        this.sell = sell;
    }

    public Number getHigh() {
        return high;
    }

    public void setHigh(Number high) {
        this.high = high;
    }

    public Number getLow() {
        return low;
    }

    public void setLow(Number low) {
        this.low = low;
    }

    public Number getLast() {
        return last;
    }

    public void setLast(Number last) {
        this.last = last;
    }

    public Number getOpen() {
        return open;
    }

    public void setOpen(Number open) {
        this.open = open;
    }

    public Number getChg() {
        return chg;
    }

    public void setChg(Number chg) {
        this.chg = chg;
    }

    public Number getVol24hour() {
        return vol24hour;
    }

    public void setVol24hour(Number vol24hour) {
        this.vol24hour = vol24hour;
    }
}
