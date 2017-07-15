package com.project.modules.dao;

import com.project.common.persistence.annotation.MyBatisDao;
import com.project.modules.entity.AccessToken;

/**
 * Created by Xuan on 2017/7/15.
 */
@MyBatisDao
public interface AccessTokenDao {
    void insert(AccessToken accessToken);

    void update(AccessToken accessToken);

    AccessToken select();
}
