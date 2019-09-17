package com.fubt.response;

/**
 * @Description WithdrawRecording
 * @auther: wangzh
 * @date:
 */
public class WithdrawRecording {
    /**
     * 充提记录ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 币种ID
     */
    private Long coinId;
    /**
     * 交易类型 RECHARGE:充值 WITHDRAW:提现
     */
    private String type;
    /**
     * 状态 WAIT-WITHDRAW:等待提现 LOCK:锁定 WITHDRAW-SUCCESS:提现成功 CANCEL:取消 RECHARGING:确认中 RECHARGE-SUCCESS:充值成功 AUDITED:已审核
     */
    private String status;
    /**
     * 数量
     */
    private String amount;
    /**
     * 手续费
     */
    private String networkFees;
    /**
     * 提币地址
     */
    private String withdrawAddress;
    /**
     * 充值地址
     */
    private String rechargeAddress;
    /**
     * 来源
     */
    private String source;
    /**
     * 交易哈希
     */
    private String hash;
    /**
     * 成功确认数
     */
    private String successCount;
    /**
     * 确认数
     */
    private String confirmationCount;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后修改时间
     */
    private String updateTime;
    /**
     * 币种名称
     */
    private String coinName;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
