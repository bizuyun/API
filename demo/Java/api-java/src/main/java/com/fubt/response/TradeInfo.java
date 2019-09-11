package com.fubt.response;

/**
 * @Description 交易对计价单位和小数位
 * @auther: wangzh
 * @date: 20190906
 */
public class TradeInfo {

    private String symbol;//交易对名称

    private String baseCurrency;//基础币种

    private String quoteCurrency;//计价币种

    private Integer pricePrecision;//价格小数位

    private Integer countPrescision;//数量小数位


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public Integer getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Integer pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Integer getCountPrescision() {
        return countPrescision;
    }

    public void setCountPrescision(Integer countPrescision) {
        this.countPrescision = countPrescision;
    }
}
