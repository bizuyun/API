package com.fubt.response;

import java.math.BigDecimal;

/**
 * @Description 成交明细
 * @auther: wangzh
 * @date:
 */
public class EntrustOrder {

    private Long id;//成交明细ID
    private String entrustId;//委单ID
    private Long tradeId;//交易对ID
    private Long buyCoinId;//买方币种ID
    private Long sellCoinId;//卖方币种ID
    private String type;//	委单类型（BUY:买单 SELL：卖单）
    private String matchType;//LIMIT:限价单 MARKET:市价单
    private BigDecimal price;//成交单价
    private BigDecimal count;//	成交数量
    private BigDecimal amount;//成交总额
    private String createTime;//成交时间
    private String symbol;//交易对symbol
    private BigDecimal fees;//手续费

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(String entrustId) {
        this.entrustId = entrustId;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getBuyCoinId() {
        return buyCoinId;
    }

    public void setBuyCoinId(Long buyCoinId) {
        this.buyCoinId = buyCoinId;
    }

    public Long getSellCoinId() {
        return sellCoinId;
    }

    public void setSellCoinId(Long sellCoinId) {
        this.sellCoinId = sellCoinId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }
}
