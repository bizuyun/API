package com.fubt.response;

import java.math.BigDecimal;

/**
 * @Description Order
 * @auther:
 * @date:
 */
public class Order {
    /**
     * 委单ID
     */
    private String id;
    /**
     *用户ID
     */
    private Long userId;
    /**
     *交易对ID
     */
    private Long tradeId;
    /**
     *买方币种ID
     */
    private Long buyCoinId;
    /**
     *卖方币种ID
     */
    private Long sellCoinId;
    /**
     *状态（NO-TRADE:未成交 SOME-TRADE:部分成交 COMPLE-TRADE:完全成交 WITHDRAWN:已撤销）
     */
    private String status;
    /**
     *委单类型（BUY:买单 SELL：卖单）
     */
    private String type;
    /**
     *LIMIT:限价单 MARKET:市价单
     */
    private String matchType;
    /**
     *委单价格
     */
    private BigDecimal price;
    /**
     *委单数量
     */
    private BigDecimal count;
    /**
     *委单金额
     */
    private BigDecimal amount;
    /**
     *剩余数量
     */
    private BigDecimal leftCount;
    /**
     * 成交数量
     */
    private BigDecimal completeCount;
    /**
     *成交均价
     *
     */
    private BigDecimal completePrice;
    /**
     *成交金额
     */
    private BigDecimal completeAmount;
    /**
     *来源
     */
    private String source;
    /**
     *创建时间
     */
    private String createTime;
    /**
     *手续费
     */
    private BigDecimal fees;
    /**
     *版本号
     */
    private Integer version;
    /**
     *交易对symbol
     */
    private String symbol;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
