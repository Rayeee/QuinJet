import me.zgy.api.UserService;
import me.zgy.bean.param.UserInfoParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhugongyi on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testAdd(){
        userService.addUser(new UserInfoParam("zgy", "120286605@qq.com", "111111", new Date(), "上海"));
    }

}
