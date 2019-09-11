package com.fubt.request;

/**
 * @Description MyEntrustOrderRequest
 * @auther: wangzh
 * @date: 20190910
 */
public class MyEntrustOrderRequest {

    /**
     *交易对symbol
     */
    private String symbol;
    /**
     *LIMIT:限价单 MARKET:市价单
     */
    private String matchType;
    /**
     *BUY:买单 SELL：卖单
     */
    private String type;
    /**
     *查询开始日期, 日期格式yyyy-MM-dd HH:mm:ss
     */
    private String startTime;
    /**
     *查询结束日期, 日期格式yyyy-MM-dd HH:mm:ss
     */
    private String endTime;
    /**
     *当前页数
     */
    private Number currentPage;
    /**
     *每页显示多少条
     */
    private Number pageSize;

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Number getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Number currentPage) {
        this.currentPage = currentPage;
    }

    public Number getPageSize() {
        return pageSize;
    }

    public void setPageSize(Number pageSize) {
        this.pageSize = pageSize;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
