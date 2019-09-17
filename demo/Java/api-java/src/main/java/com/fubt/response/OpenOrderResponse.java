package com.fubt.response;

import java.util.List;

/**
 * @Description OpenOrderResponse
 * @auther: wangzh
 * @date:
 */
public class OpenOrderResponse extends BaseResponse {
    private List<Order> data;

    public List<Order> getData() {
        return data;
    }

    public void setData(List<Order> data) {
        this.data = data;
    }
}
