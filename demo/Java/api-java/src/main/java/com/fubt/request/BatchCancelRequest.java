package com.fubt.request;

/**
 * @Description batchCancelRequest
 * @auther: wangzh
 * @date: 20190910
 */
public class BatchCancelRequest {
    /**
     *交易对symbol  规则： 基础币种+计价币种。如BTC/USDT，symbol 为 btcusdt
     */
    private String symbol;
    /**
     *BUY:买单 SELL：卖单
     */
    private String type;

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
