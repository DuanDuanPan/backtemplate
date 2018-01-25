/**
 * @Project Name :  base
 * @Package Name :  com.orient.controller
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-22 4:47 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.ping;

import com.orient.web.base.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  panduanduan
 * @Description :  心跳检测
 * @Creation Date:  2018-01-22 4:47 PM
 */
@RestController
@CrossOrigin("*")
public class PingController extends BaseController {


    @GetMapping("/")
    public Integer shake() {
        return 1;
    }


}