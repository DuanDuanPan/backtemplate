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
import com.orient.persistent.system.repository.RoleRepository;
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


    @Test
    public void testAdd() {
        OrientSmRolePO rolePO = OrientSmRolePO.builder().name("test").isDel(0l).
                build();
        roleRepository.save(rolePO);
    }

    @Test
    public void testModify() {

    }

    @Test
    public void testAssignUser() {

    }

    @Test
    public void testUnAssignUser() {

    }

    @Test
    public void testDeleteUser() {

    }

    @Test
    public void testDelete() {

    }

}