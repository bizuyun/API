package com.fubt.response;

import java.math.BigDecimal;

/**
 * @Description 委单
 * @auther: wangzh
 * @date:
 */
public class Entrust {

    private String id;//委单ID
    private Long userId;//用户ID
    private Long tradeId;//交易对ID
    private Long buyCoinId;//买方币种ID
    private Long sellCoinId;//卖方币种ID
    private String status;//状态（NO-TRADE:未成交 SOME-TRADE:部分成交 COMPLE-TRADE:完全成交 WITHDRAWN:已撤销）
    private String type;//	委单类型（BUY:买单 SELL：卖单）
    private String matchType;//LIMIT:限价单 MARKET:市价单
    private BigDecimal price;//委单单价
    private BigDecimal count;//	委单数量
    private BigDecimal amount;//委单总价
    private BigDecimal leftCount;//剩余数量
    private BigDecimal completeCount;//完成数量
    private BigDecimal completePrice;//已成交均价
    private BigDecimal completeAmount;//成交总额
    private String createTime;//创建时间
    private String symbol;//交易对symbol
    private BigDecimal fees;//手续费
    private Integer version;//版本

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigDecimal getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(BigDecimal leftCount) {
        this.leftCount = leftCount;
    }

    public BigDecimal getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(BigDecimal completeCount) {
        this.completeCount = completeCount;
    }

    public BigDecimal getCompletePrice() {
        return completePrice;
    }

    public void setCompletePrice(BigDecimal completePrice) {
        this.completePrice = completePrice;
    }

    public BigDecimal getCompleteAmount() {
        return completeAmount;
    }

    public void setCompleteAmount(BigDecimal completeAmount) {
        this.completeAmount = completeAmount;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
