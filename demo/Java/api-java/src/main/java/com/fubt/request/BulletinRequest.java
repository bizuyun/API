package com.fubt.request;

/**
 * @Description BulletinRequest
 * @auther: wangzh
 * @date: 20190919
 */
public class BulletinRequest {

    private String language;

    private String pageNum;

    private String pageSize;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
