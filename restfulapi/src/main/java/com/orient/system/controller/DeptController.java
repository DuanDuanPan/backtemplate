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

import com.orient.persistent.system.po.SmDeptPO;
import com.orient.persistent.system.repository.SmDeptMapper;
import com.orient.web.base.BaseController;
import com.orient.web.enums.StateEnum;
import com.orient.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  部门restful控制类
 * @Creation Date:  2018-01-24 1:47 PM
 */
@RestController
public class DeptController extends BaseController {

    @Autowired
    SmDeptMapper smDeptMapper;

    @ApiOperation("获取所有部门信息")
    @GetMapping("/dept")
    public OrientRestfulResp<List<SmDeptPO>> getDepts() {
        OrientRestfulResp<List<SmDeptPO>> retVal = restProcessor(() -> {
            List<SmDeptPO> deptPO = smDeptMapper.findAll();
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(deptPO).build();
        });
        return retVal;
    }
}