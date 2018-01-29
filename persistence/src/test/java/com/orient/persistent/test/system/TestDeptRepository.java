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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-01-26 2:53 PM
 */
@RunWith(SpringRunner.class)
@Transactional
@Rollback
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
        Assert.assertEquals(0, count.size());
    }

    @Test
    public void testInsert() {
        SmDeptPO smDeptPO = new SmDeptPO();
        smDeptPO.setName("测试中文");
        smDeptPOMapper.insert(smDeptPO);
        Assert.assertNotNull(smDeptPO.getId());
    }

    @Test
    public void testUpdate() {
        Example example = new Example(SmDeptPO.class);
        example.createCriteria().andEqualTo("name", "测试中文");
        SmDeptPO smDeptPO = smDeptPOMapper.selectOneByExample(example);
        Assert.assertNotNull(smDeptPO);
        smDeptPO.setDescription("desc");
        smDeptPOMapper.updateByPrimaryKey(smDeptPO);
    }

    @Test
    public void testDelete() {
        Example example = new Example(SmDeptPO.class);
        example.createCriteria().andEqualTo("name", "测试中文");
        SmDeptPO smDeptPO = smDeptPOMapper.selectOneByExample(example);
        Assert.assertNotNull(smDeptPO);
        smDeptPOMapper.delete(smDeptPO);
        int count = smDeptPOMapper.selectCount(null);
        Assert.assertEquals(0, count);
    }
}