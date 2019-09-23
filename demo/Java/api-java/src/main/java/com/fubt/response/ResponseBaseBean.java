package com.fubt.response;

/**
 * @Description 公共响应类
 * @auther: wangzh
 * @date: 20190923
 */
public class ResponseBaseBean<T> {

    private String message;

    private String status;

    private T data; //数据

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public static ResponseBaseBean success(Object data, String msg, String sta) {
        ResponseBaseBean responseBaseBean = new ResponseBaseBean();
        responseBaseBean.setData(data);
        responseBaseBean.setMessage(msg);
        responseBaseBean.setStatus(sta);
        return responseBaseBean;
    }

    public static ResponseBaseBean info(Object data, String msg) {
        ResponseBaseBean responseBaseBean = new ResponseBaseBean();
        responseBaseBean.setData(data);
        responseBaseBean.setMessage(msg);
        return responseBaseBean;
    }

    public static ResponseBaseBean error(String msg, String sta) {
        ResponseBaseBean responseBaseBean = new ResponseBaseBean();
        responseBaseBean.setMessage(msg);
        responseBaseBean.setStatus(sta);
        return responseBaseBean;
    }

    public static ResponseBaseBean error(String msg) {
        ResponseBaseBean responseBaseBean = new ResponseBaseBean();
        responseBaseBean.setMessage(msg);
        return responseBaseBean;
    }

    @Override
    public String toString() {
        return "ResponseBaseBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
