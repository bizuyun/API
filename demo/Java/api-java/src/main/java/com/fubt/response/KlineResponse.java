package com.fubt.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description KlineResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class KlineResponse extends BaseResponse {
    private List<List<BigDecimal>> data;

    public List<List<BigDecimal>> getData() {
        return data;
    }

    public void setData(List<List<BigDecimal>> data) {
        this.data = data;
    }
}
