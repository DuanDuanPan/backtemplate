/**
 * @Project Name :  backtemplate
 * @Package Name :  test
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 2:53 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.test.system;

import com.orient.OrientApplication;
import com.orient.persistent.system.po.SmDeptPO;
import com.orient.persistent.system.repository.SmDeptMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-01-26 2:53 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {OrientApplication.class})
public class TestDeptRepository {

    @Autowired
    SmDeptMapper smDeptMapper;

    @Test
    public void testFindAll() {
        List<SmDeptPO> deptPOS = smDeptMapper.findAll();
        Assert.assertEquals(1, deptPOS.size());
    }
}