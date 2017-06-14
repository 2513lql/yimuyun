package com.project.common;

public class HttpOutMessage {


    //返回code
    public static int SUCCESS = 1000;
    public static int ERROR = 1001;

    private Integer code;// 返回码

    private Object content;


    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}