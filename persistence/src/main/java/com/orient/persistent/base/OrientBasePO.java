/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 2:47 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :  panduanduan
 * @Description :  base persistent object
 * @Creation Date:  2018-01-26 2:47 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrientBasePO implements Serializable {

    protected Long id;

    protected Date createTime;

    protected String createUser;

    protected Date modifyTime;

    protected String updateUser;
}