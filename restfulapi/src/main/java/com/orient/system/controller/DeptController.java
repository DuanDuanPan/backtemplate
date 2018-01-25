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

import com.orient.persistent.system.po.OrientSmDeptPO;
import com.orient.persistent.system.repository.DeptRepository;
import com.orient.persistent.util.IsDel;
import com.orient.web.base.BaseController;
import com.orient.web.enums.StateEnum;
import com.orient.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    DeptRepository deptRepository;

    @ApiOperation("保存部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptName", value = "部门名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "depDesc", value = "部门职责描述", dataType = "String", paramType = "query")
    })
    @PostMapping("/dept")
    public OrientRestfulResp<String> saveDept(String deptName, String depDesc) {
        OrientSmDeptPO deptPO = new OrientSmDeptPO();
        deptPO.setName(deptName);
        deptPO.setDescr(depDesc);
        deptPO.setIsDel(IsDel.VALID);
        deptRepository.save(deptPO);
        OrientRestfulResp retVal = restProcessor(() -> OrientRestfulResp.builder().
                status(StateEnum.SUCCESS.getState()).data(String.valueOf(deptPO.getId())).build());
        return retVal;
    }

    @ApiOperation("根据部门id获取部门详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门id", dataType = "Long", paramType = "path")
    })
    @GetMapping("/dept/{id}")
    public OrientRestfulResp<OrientSmDeptPO> getDepts(@PathVariable Long id) {
        OrientRestfulResp<OrientSmDeptPO> retVal = restProcessor(() -> {
            OrientSmDeptPO deptPO = deptRepository.findOne(id);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(deptPO).build();
        });
        return retVal;
    }
}