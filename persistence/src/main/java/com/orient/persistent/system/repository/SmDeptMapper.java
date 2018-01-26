/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.system.repository
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 2:50 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.system.repository;

import com.orient.persistent.system.po.SmDeptPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  crud TABLE SM_DEPT
 * @Creation Date:  2018-01-26 2:50 PM
 */
@Mapper
public interface SmDeptMapper {

    @Select("select * from sm_dept where is_del = 0")
    List<SmDeptPO> findAll();
}