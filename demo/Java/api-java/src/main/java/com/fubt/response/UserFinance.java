package com.fubt.response;

/**
 * @Description
 * @auther: UserFinance
 * @date:
 */
public class UserFinance {
    private String coinName;//币种名称
    private String total;//可用余额
    private String frozen;//冻结余额
    private String financing;//理财余额

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
