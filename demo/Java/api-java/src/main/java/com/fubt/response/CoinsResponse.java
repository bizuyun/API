package com.fubt.response;

import java.util.List;

/**
 * @Description 币种信息response
 * @auther: wangzh
 * @date: 20190906
 */
public class CoinsResponse extends BaseResponse{

    private List<String> data;//币种小写字符串 list

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
