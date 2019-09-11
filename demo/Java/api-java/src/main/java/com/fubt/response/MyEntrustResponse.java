package com.fubt.response;

import java.util.List;
import java.util.Map;

/**
 * @Description MyEntrustResponse
 * @auther:
 * @date:
 */
public class MyEntrustResponse extends BaseResponse {

    private List<Map<String, Object>> data;

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    private Integer pages;

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
