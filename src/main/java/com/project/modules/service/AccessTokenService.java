package com.project.modules.service;

import com.project.modules.dao.AccessTokenDao;
import com.project.modules.entity.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xuan on 2017/7/15.
 */
@Service
@Transactional(readOnly = false)
public class AccessTokenService {
    @Autowired
    AccessTokenDao accessTokenDao;

    public void insert(AccessToken accessToken) {
        accessTokenDao.insert(accessToken);
    }

    public void update(AccessToken accessToken) {
        accessTokenDao.update(accessToken);
    }

    public AccessToken select() {
        return accessTokenDao.select();
    }
}
