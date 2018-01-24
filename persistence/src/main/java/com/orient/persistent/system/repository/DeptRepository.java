/**
 * @Project Name :  base
 * @Package Name :  com.orient.system.repository
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 5:17 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.system.repository;

import com.orient.persistent.system.po.OrientSmDeptPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :  panduanduan
 * @Description :  部门数据库操作层
 * @Creation Date:  2018-01-23 5:17 PM
 */
@Repository
public interface DeptRepository extends JpaRepository<OrientSmDeptPO, Long> {

    List<OrientSmDeptPO> findByNameContaining(String deptName);
}