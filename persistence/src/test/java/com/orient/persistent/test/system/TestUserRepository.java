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
import com.orient.persistent.system.mapper.SmUserPOMapper;
import com.orient.persistent.system.po.SmUserPO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author :  panduanduan
 * @Description :  test user mapper
 * @Creation Date:  2018-01-26 2:53 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {OrientApplication.class})
public class TestUserRepository {

    SmUserPOMapper smUserPOMapper;

    @Autowired
    SqlSession sqlSession;

    @Before
    public void setUp() {
        smUserPOMapper = sqlSession.getMapper(SmUserPOMapper.class);
    }

    @Test
    public void testInsertUser() {
        SmUserPO userPO = SmUserPO.builder().userName("test").allName("测试").
                userPassword("123456").isDel(0).build();
        smUserPOMapper.insert(userPO);
        Assert.assertNotNull(userPO.getId());
    }

    @Test
    public void testFindAndUpdateUser() {
        Example example = new Example(SmUserPO.class);
        example.createCriteria().andEqualTo("allName", "测试");
        SmUserPO userPO = smUserPOMapper.selectByPrimaryKey(0);
        Assert.assertNotNull(userPO);
        userPO.setUpdateTime(new Date());
        smUserPOMapper.updateByPrimaryKey(userPO);
    }

    @Test
    public void testDeleteUser() {
        Example example = new Example(SmUserPO.class);
        example.createCriteria().andEqualTo("allName", "测试");
        smUserPOMapper.deleteByExample(example);
        int count = smUserPOMapper.selectCount(null);
        Assert.assertEquals(0, count);
    }
}