package me.zgy.mapping;

import me.zgy.bean.entity.UserInfoEntity;
import me.zgy.routing.DataSource;

/**
 * Created by zhugongyi on 2017/5/5.
 */
public interface UserInfoDao {

    @DataSource("dataSource2")
    int add(UserInfoEntity userInfoEntity);

}
