package com.fubt.response;

/**
 * @Description ResponseBaseSizeBean
 * @auther:
 * @date:
 */
public class ResponseBaseSizeBean<T> {

    private String message;

    private String status;

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    private Integer pages;

    private T data; //数据

    public static ResponseBaseSizeBean success(Integer pageNum, Integer pageSize,
                                               Integer total, Integer pages, Object data, String msg, String sta) {
        ResponseBaseSizeBean responseBaseSizeBean = new ResponseBaseSizeBean();
        responseBaseSizeBean.setPageNum(pageNum);
        responseBaseSizeBean.setPageSize(pageSize);
        responseBaseSizeBean.setPages(pages);
        responseBaseSizeBean.setTotal(total);
        responseBaseSizeBean.setData(data);
        responseBaseSizeBean.setMessage(msg);
        responseBaseSizeBean.setStatus(sta);
        return responseBaseSizeBean;
    }

    public static ResponseBaseSizeBean error(String msg){
        ResponseBaseSizeBean responseBaseSizeBean = new ResponseBaseSizeBean();
        responseBaseSizeBean.setMessage(msg);
        return responseBaseSizeBean;
    }

    public static ResponseBaseSizeBean error(String msg,String sta){
        ResponseBaseSizeBean responseBaseSizeBean = new ResponseBaseSizeBean();
        responseBaseSizeBean.setMessage(msg);
        responseBaseSizeBean.setStatus(sta);
        return responseBaseSizeBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
