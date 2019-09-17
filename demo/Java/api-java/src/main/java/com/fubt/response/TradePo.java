package com.fubt.response;

/**
 * @Description TradePo
 * @auther: wangzh
 * @date:
 */
public class TradePo {
    /**
     * 成交价格
     */
    private Number price;
    /**
     * 成交数量
     */
    private Number amount;
    /**
     *成交方向(BUY,SELL)
     */
    private String direction;
    /**
     * 时间戳
     */
    private Number time;

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Number getTime() {
        return time;
    }

    public void setTime(Number time) {
        this.time = time;
    }
}
