package com.fubt;

import java.io.Serializable;

/**
 * @Description ApiException
 * @auther: wangzh
 * @date: 20190906
 */
public class ApiException<T> implements Serializable {

    /**
     * 状态码
     */
    private String code = "success";

    /**
     * 信息
     */
    private String message = "ok";

    /**
     * 是否成功
     */
    private boolean status = true;

    /**
     * 返回的数据
     */
    private T data;


}
