package com.fubt.response;

import java.io.Serializable;

/**
 * @Description BaseEntity
 * @auther: wangzh
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;//状态

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String message;//信息

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    private Integer pages;
}
