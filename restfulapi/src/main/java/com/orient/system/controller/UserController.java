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

import com.orient.persistent.system.po.OrientSmUserPO;
import com.orient.persistent.system.repository.UserRepository;
import com.orient.web.base.BaseController;
import com.orient.web.enums.StateEnum;
import com.orient.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  用户restful控制类
 * @Creation Date:  2018-01-24 1:47 PM
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation("根据用户id获取部用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Long", paramType = "path")
    })
    @GetMapping("/user/{id}")
    public OrientRestfulResp<OrientSmUserPO> getUserById(@PathVariable Long id) {
        OrientRestfulResp<OrientSmUserPO> retVal = restProcessor(() -> {
            OrientSmUserPO userPO = userRepository.findOne(id);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(userPO).build();
        });
        return retVal;
    }

    @ApiOperation("根据角色id获取部用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色id", dataType = "Long", paramType = "path")
    })
    @GetMapping("/user/role/{roleId}")
    public OrientRestfulResp<List<OrientSmUserPO>> getUsersByRoleId(@PathVariable Long roleId) {
        OrientRestfulResp<List<OrientSmUserPO>> retVal = restProcessor(() -> {
            List<OrientSmUserPO> queryResult = userRepository.findAll();
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(queryResult).build();
        });
        return retVal;
    }
}