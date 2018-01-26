/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.system.po
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 2:45 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.system.po;

import com.orient.persistent.base.OrientBasePO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :  panduanduan
 * @Description :  mybatis dept persistent object
 * @Creation Date:  2018-01-26 2:45 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmDeptPO extends OrientBasePO {

    private String name;

    private String descr;

    private Long isDel;
}