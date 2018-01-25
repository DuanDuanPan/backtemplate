/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.util
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-25 2:34 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.util;

/**
 * @author :  panduanduan
 * @Description :  是否有效枚举 用于@Enumerated
 * @Creation Date:  2018-01-25 2:34 PM
 */
public enum IsDel {

    VALID("有效"), INVALID("无效");

    private String value;

    private IsDel(String value) {
        this.value = value;
    }
}
