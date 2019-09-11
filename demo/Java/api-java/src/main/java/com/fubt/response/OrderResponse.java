package com.fubt.response;

/**
 * @Description OrderResponse
 * @auther:
 * @date:
 */
public class OrderResponse extends BaseResponse {
    private Order data;

    public Order getData() {
        return data;
    }

    public void setData(Order data) {
        this.data = data;
    }
}
