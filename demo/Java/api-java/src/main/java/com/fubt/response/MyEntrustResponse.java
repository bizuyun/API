package com.fubt.response;

import java.util.List;

/**
 * @Description MyEntrustResponse
 * @auther: wangzh
 * @date:
 */
public class MyEntrustResponse extends BaseEntity {

    private List<Entrust> data;

    public List<Entrust> getData() {
        return data;
    }

    public void setData(List<Entrust> data) {
        this.data = data;
    }
}
