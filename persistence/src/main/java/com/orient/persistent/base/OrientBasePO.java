/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 10:04 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.base;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author :  panduanduan
 * @Description :  base persistent object with lombok
 * @Creation Date:  2018-01-24 10:04 PM
 */
public class OrientBasePO implements Serializable {

    @Transient
    private String cacheKey = "orient-po";
}