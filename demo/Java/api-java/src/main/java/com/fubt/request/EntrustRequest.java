package com.fubt.request;

/**
 * @Description EntrustRequest
 * @auther: wangzh
 * @date:20190910
 */
public class EntrustRequest {
    /**
     * 委托数量
     */
    private Number count;
    /**
     *LIMIT:限价单 MARKET:市价单
     */
    private String matchType;
    /**
     *交易密码
     */
    private String payPwd;
    /**
     *委托价格（市价单可为空）
     */
    private Number price;
    /**
     *来源 API
     */
    private String source;
    /**
     *交易对symbol
     */
    private String symbol;
    /**
     *BUY:买单 SELL：卖单
     */
    private String type;


    public Number getCount() {
        return count;
    }

    public void setCount(Number count) {
        this.count = count;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
