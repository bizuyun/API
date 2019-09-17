package com.fubt.response;

import java.util.List;

/**
 * @Description MyEntrustOrderResponse
 * @auther: wangzh
 * @date: 20190910
 */
public class MyEntrustOrderResponse extends BaseEntity {
    private List<EntrustOrder> data;

    public List<EntrustOrder> getData() {
        return data;
    }

    public void setData(List<EntrustOrder> data) {
        this.data = data;
    }
}
