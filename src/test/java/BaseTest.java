import me.zgy.api.UserService;
import me.zgy.bean.param.UserInfoParam;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhugongyi on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BaseTest {

    @Resource
    private UserService userService;

    @Resource
    private ThreadPoolTaskExecutor executor;

    int a = 0;

    @Test
    public void testAdd() throws InterruptedException, ExecutionException, TimeoutException {
//        userService.addUser(new UserInfoParam("zgy", "120286605@qq.com", "111111", new Date(), "上海"));
        FutureTask task = new FutureTask(new Say());
        executor.execute(task);
        a = (int)task.get(1000, TimeUnit.MILLISECONDS);
        System.out.println(a);
    }


    class Say implements Callable {


        @Override
        public Object call() throws Exception {
            return 1;
        }
    }
}
