/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.web.enums
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:58 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.web.enums;

/**
 * @author :  panduanduan
 * @Description :  返回状态枚举
 * @Creation Date:  2018-01-24 1:58 PM
 */
public enum StateEnum {

    SUCCESS(200), UNAUTHORIZED(401), FORBIDDEN(403), ERROR(500);

    private int state;

    StateEnum(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
