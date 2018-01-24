/**
 * @Project Name :  base
 * @Package Name :  com.orient.system.repository
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 5:17 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistence.system.repository;

import com.orient.persistence.system.po.OrientSmUserPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author :  panduanduan
 * @Description :  部门数据库操作层
 * @Creation Date:  2018-01-23 5:17 PM
 */
@Repository
public interface UserRepository extends CrudRepository<OrientSmUserPO, Long> {

}