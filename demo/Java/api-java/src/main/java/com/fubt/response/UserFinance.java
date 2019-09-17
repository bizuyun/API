package com.fubt.response;

/**
 * @Description
 * @auther: UserFinance
 * @date:
 */
public class UserFinance {
    /**
     * 币种名称
     */
    private String coinName;
    /**
     * 可用余额
     */
    private String total;
    /**
     * 冻结余额
     */
    private String frozen;
    /**
     * 理财余额
     */
    private String financing;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getFinancing() {
        return financing;
    }

    public void setFinancing(String financing) {
        this.financing = financing;
    }
}
