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

import com.orient.persistent.system.po.OrientSmRolePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author :  panduanduan
 * @Description :  角色数据库操作层
 * @Creation Date:  2018-01-23 5:17 PM
 */
@Repository
public interface RoleRepository extends JpaRepository<OrientSmRolePO, Long> {

    OrientSmRolePO findByName(String roleName);
}