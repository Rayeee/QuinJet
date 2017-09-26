package me.zgy.service.impl;

import me.zgy.api.UserService;
import me.zgy.bean.entity.UserInfoEntity;
import me.zgy.bean.param.UserInfoParam;
import me.zgy.mapping.UserInfoDao;
import me.zgy.routing.DataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhugongyi on 2017/5/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    @DataSource("dataSource2")
    public void addUser(UserInfoParam param) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(param, userInfoEntity);
        userInfoDao.add(userInfoEntity);
    }
}
