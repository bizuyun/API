package com.fubt.request;

/**
 * @Description WithdrawRequest
 * @auther: wangzh
 * @date: 20190910
 */
public class WithdrawRequest {

    private String coinName;
    private String withdrawAddress;
    private String payCode;
    private String amount;
    private String networkFees;
    private String remark;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getWithdrawAddress() {
        return withdrawAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }
    
    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNetworkFees() {
        return networkFees;
    }

    public void setNetworkFees(String networkFees) {
        this.networkFees = networkFees;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
