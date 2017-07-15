package com.project.modules.entity;

import java.util.Date;

/**
 * Created by Xuan on 2017/7/15.
 */
public class AccessToken {
    private String accessToken;
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
