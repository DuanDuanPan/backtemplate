/**
 * @Project Name :  base
 * @Package Name :  com.orient.test
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 9:57 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package test;

import com.orient.OrientApplication;
import com.orient.persistent.system.po.OrientSmUserPO;
import com.orient.persistent.system.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :  panduanduan
 * @Description :  测试属性类自动装载
 * @Creation Date:  2018-01-23 9:57 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = OrientApplication.class)
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testAddUser() {
        OrientSmUserPO userPO = new OrientSmUserPO();
        userPO.setUserName("system");
        userPO.setAllName("系统管理员");
        userPO.setPassword("123456");
        userPO.setIsDel(0l);
        userRepository.save(userPO);
        Assert.assertNotNull(userPO.getId());
        Assert.assertNotNull(userPO.getCreateTime());
    }

}