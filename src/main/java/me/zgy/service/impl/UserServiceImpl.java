package me.zgy.service.impl;

import me.zgy.api.UserService;
import me.zgy.bean.entity.UserInfoEntity;
import me.zgy.bean.param.UserInfoParam;
import me.zgy.bean.vo.UserInfoVo;
import me.zgy.mapping.UserInfoDao;
import me.zgy.routing.DataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhugongyi on 2017/5/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(Long id) {
        System.out.println(queryById(id).getVersion());
        System.out.println(queryById(id).getVersion());
        System.out.println(queryById(id).getVersion());
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public UserInfoVo queryById(Long id) {
        return userInfoDao.queryById(id);
    }

    @Override
    public List<UserInfoVo> queryByAddress(String address) {
        return userInfoDao.queryByAddress(address);
    }

    @Override
    @DataSource("dataSource2")
    public void addUser(UserInfoParam param) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(param, userInfoEntity);
        userInfoDao.add(userInfoEntity);
    }

}
