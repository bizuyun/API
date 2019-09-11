package com.fubt.response;

import java.util.List;
import java.util.Map;

/**
 * @Description DepthResponse
 * @auther: wangzh
 * @date: 20190909
 */
public class DepthResponse extends BaseResponse{

    private Map<String,Object> data;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
