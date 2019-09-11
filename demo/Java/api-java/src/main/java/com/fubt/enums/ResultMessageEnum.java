package com.fubt.enums;

public enum ResultMessageEnum {

    ERROR_ENUM("ERROR_ENUM","调用接口失败"),

    INFO_ENUM("INFO_ENUM","该接口数据为空"),

    PARAM_ENUM("PARAM_ENUM","参数错误");


    private String code;

    private String message;

    ResultMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
