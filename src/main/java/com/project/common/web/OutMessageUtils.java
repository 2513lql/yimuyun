package com.project.common.web;

/**
 * Created by LQL on 2017/3/11.
 */
public class OutMessageUtils {


    //返回消息
    public static HttpOutMessage buildOutMessage(int code,Object object){
        HttpOutMessage httpOutMessage = new HttpOutMessage();
        httpOutMessage.setCode(code);
        httpOutMessage.setContent(object);
        return httpOutMessage;
    }

}
