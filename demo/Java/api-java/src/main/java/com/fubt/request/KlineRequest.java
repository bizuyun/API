package com.fubt.request;

/**
 * @Description KlineRequest
 * @auther: wangzh
 * @date: 20190909
 */
public class KlineRequest {
    /**
     * 交易对标识(BTCUSDT,ETHUSDT...)
     */
    private String symbol;
    /**
     * 周期标识(min,min5,min15,min30,hour1,hour4,day,week)
     */
    private String klineType;
    /**
     * 长度 (step0 50条, STEP1 100条, STEP2 150条, STEP3 200条, STEP4 250条, STEP5 300条)
     */
    private String klineStep;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getKlineType() {
        return klineType;
    }

    public void setKlineType(String klineType) {
        this.klineType = klineType;
    }

    public String getKlineStep() {
        return klineStep;
    }

    public void setKlineStep(String klineStep) {
        this.klineStep = klineStep;
    }
}
