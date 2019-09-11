package com.fubt.response;

import java.util.List;
import java.util.Map;

/**
 * @Description OpenOrderResponse
 * @auther:
 * @date:
 */
public class OpenOrderResponse extends BaseResponse {
    private List<Map<String, Object>> data;

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
