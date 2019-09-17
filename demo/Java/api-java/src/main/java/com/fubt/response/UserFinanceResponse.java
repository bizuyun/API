package com.fubt.response;

import java.util.List;
/**
 * @Description UserFinanceResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class UserFinanceResponse extends BaseResponse {

    private List<UserFinance> data;

    public List<UserFinance> getData() {
        return data;
    }

    public void setData(List<UserFinance> data) {
        this.data = data;
    }
}
