/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.system.controller
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:47 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.system.controller;

import com.orient.persistent.system.mapper.SmDeptPOMapper;
import com.orient.persistent.system.po.SmDeptPO;
import com.orient.web.base.BaseController;
import com.orient.web.enums.StateEnum;
import com.orient.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  panduanduan
 * @Description :  部门restful控制类
 * @Creation Date:  2018-01-24 1:47 PM
 */
@RestController
public class DeptController extends BaseController {


    @Autowired
    SqlSession sqlSession;

    @ApiOperation("根据部门id获取部门详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门id", dataType = "Integer", paramType = "path")
    })
    @GetMapping("/dept/{id}")
    public OrientRestfulResp<SmDeptPO> getDepts(@PathVariable Integer id) {
        SmDeptPOMapper mapper = sqlSession.getMapper(SmDeptPOMapper.class);
        OrientRestfulResp<SmDeptPO> retVal = restProcessor(() -> {
            SmDeptPO deptPO = mapper.selectByPrimaryKey(id);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(deptPO).build();
        });
        return retVal;
    }

    @ApiOperation("新建部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "部门名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "职责描述", dataType = "String", paramType = "query")
    })
    @PostMapping("/dept")
    public OrientRestfulResp<Integer> saveDept(String name, String desc) {
        SmDeptPOMapper mapper = sqlSession.getMapper(SmDeptPOMapper.class);
        OrientRestfulResp<Integer> retVal = restProcessor(() -> {
            SmDeptPO smDeptPO = SmDeptPO.builder().name(name).description(desc).build();
            mapper.insert(smDeptPO);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(smDeptPO.getId()).build();
        });
        return retVal;
    }

}