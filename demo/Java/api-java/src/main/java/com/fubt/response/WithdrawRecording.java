package com.fubt.response;

/**
 * @Description WithdrawRecording
 * @auther:
 * @date:
 */
public class WithdrawRecording {

    private Long id;//充提记录ID
    private Long userId;//用户ID
    private Long coinId;//币种ID
    private String type;//交易类型 RECHARGE:充值 WITHDRAW:提现
    private String statusW;//状态 WAIT-WITHDRAW:等待提现 LOCK:锁定 WITHDRAW-SUCCESS:提现成功 CANCEL:取消 RECHARGING:确认中 RECHARGE-SUCCESS:充值成功 AUDITED:已审核
    private String amount;//	数量
    private String networkFees;//手续费
    private String withdrawAddress;//提币地址
    private String rechargeAddress;//充值地址
    private String source;//来源
    private String hash;//交易哈希
    private String successCount;//成功确认数
    private String confirmationCount;//确认数
    private String createTime;//创建时间
    private String updateTime;//最后修改时间
    private String coinName;//币种名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusW() {
        return statusW;
    }

    public void setStatusW(String statusW) {
        this.statusW = statusW;
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

    public String getWithdrawAddress() {
        return withdrawAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }

    public String getRechargeAddress() {
        return rechargeAddress;
    }

    public void setRechargeAddress(String rechargeAddress) {
        this.rechargeAddress = rechargeAddress;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount;
    }

    public String getConfirmationCount() {
        return confirmationCount;
    }

    public void setConfirmationCount(String confirmationCount) {
        this.confirmationCount = confirmationCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
}
