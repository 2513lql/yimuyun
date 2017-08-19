package com.project.modules.entity;

/**
 * Created by Xuan on 2017/7/15.
 */
public class AccessToken {
    private String accessToken;
    private String updateTime;
    private String jsapiTicket;

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
