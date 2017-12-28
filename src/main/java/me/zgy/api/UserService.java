package me.zgy.api;

import me.zgy.bean.param.UserInfoParam;
import me.zgy.bean.vo.UserInfoVo;

import java.util.List;

/**
 * Created by zhugongyi on 2017/5/5.
 */
public interface UserService {

    void update(Long id);

    UserInfoVo queryById(Long id);

    List<UserInfoVo> queryByAddress(String address);

    void addUser(UserInfoParam param);

}
