/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.web.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 2:06 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.base;

import com.orient.web.result.OrientRestfulResp;

/**
 * @author :  panduanduan
 * @Description :  返回结果处理函数
 * @Creation Date:  2018-01-24 2:06 PM
 */
@FunctionalInterface
public interface ResultProcessor {
    OrientRestfulResp process();
}
