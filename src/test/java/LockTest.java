import me.zgy.utils.JsonUtil;
import org.junit.Test;

/**
 * Created by Rayee on 2017/12/25.
 */
public class LockTest extends BaseTest {

    @Test
    public void testLock01(){
        System.out.println(JsonUtil.toJson(userService.queryById(48l)));
    }

    @Test
    public void testLock02(){
        userService.update(48l);
    }

}
