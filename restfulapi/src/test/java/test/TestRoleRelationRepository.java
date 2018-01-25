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
import com.orient.persistent.system.po.OrientSmRolePO;
import com.orient.persistent.system.po.OrientSmUserPO;
import com.orient.persistent.system.repository.RoleRepository;
import com.orient.persistent.system.repository.UserRepository;
import com.orient.persistent.util.IsDel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class TestRoleRelationRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Test
    public void testAdd() {
        OrientSmRolePO rolePO = OrientSmRolePO.builder().name("test").isDel(IsDel.VALID).
                build();
        roleRepository.save(rolePO);
    }

    @Test
    public void testModify() {
        OrientSmRolePO rolePO = roleRepository.findByName("test");
        logger.warn("query role for test:" + rolePO);
        Assert.assertNotNull(rolePO);
        rolePO.setIsDel(IsDel.VALID);
        roleRepository.save(rolePO);
        logger.warn("delete role test:" + rolePO);
        long count = roleRepository.count();
        Assert.assertEquals(4l, count);
    }

    @Test
    public void testAssignUser() {
        OrientSmRolePO rolePO = roleRepository.findByName("test");
        logger.warn("query role for test:" + rolePO);
        Assert.assertNotNull(rolePO);
        OrientSmUserPO userPO = userRepository.findByUserName("system");
        Assert.assertNotNull(userPO);
        rolePO.getUsers().add(userPO);
        logger.warn("assign user system to test role");
        roleRepository.save(rolePO);

    }

    @Test
    public void testUnAssignUser() {
        OrientSmRolePO rolePO = roleRepository.findByName("test");
        logger.warn("query role for test:" + rolePO);
        Assert.assertNotNull(rolePO);
        OrientSmUserPO userPO = userRepository.findByUserName("system");
        Assert.assertNotNull(userPO);
        rolePO.getUsers().remove(userPO);
        logger.warn("unAssign user system to test role");
        roleRepository.save(rolePO);
    }

    @Test
    public void testDeleteUser() {

    }

    @Test
    public void testDelete() {

    }

}