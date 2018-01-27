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
import com.orient.persistent.system.mapper.SmDeptPOMapper;
import com.orient.persistent.system.po.SmDeptPO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-01-26 2:53 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {OrientApplication.class})
public class TestDeptRepository {

    SmDeptPOMapper smDeptPOMapper;

    @Autowired
    SqlSession sqlSession;

    @Before
    public void setUp() {
        smDeptPOMapper = sqlSession.getMapper(SmDeptPOMapper.class);
    }

    @Test
    public void testFindAll() {
        List<SmDeptPO> count = smDeptPOMapper.selectAll();
        Assert.assertEquals(1, count.size());
    }

    @Test
    public void testFindOne() {
        SmDeptPO smDeptPO = smDeptPOMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(smDeptPO);
    }

    @Test
    public void testInsert() {
        SmDeptPO smDeptPO = new SmDeptPO();
        smDeptPO.setName("test1");
        smDeptPOMapper.insert(smDeptPO);
        Assert.assertNotNull(smDeptPO.getId());
    }

    @Test
    public void testUpdate() {
        Example example = new Example(SmDeptPO.class);
        example.createCriteria().andEqualTo("name", "test");
        SmDeptPO smDeptPO = smDeptPOMapper.selectOneByExample(example);
        Assert.assertNotNull(smDeptPO);
        smDeptPO.setDescription("desc");
        smDeptPOMapper.updateByPrimaryKey(smDeptPO);
    }
}