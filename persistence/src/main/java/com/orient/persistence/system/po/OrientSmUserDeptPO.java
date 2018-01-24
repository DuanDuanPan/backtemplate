/**
 * @Project Name :  base
 * @Package Name :  com.orient.persistent.system
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 4:56 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistence.system.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author :  panduanduan
 * @Description :  用户部门中间表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_USER_DEPT")
public class OrientSmUserDeptPO {
    private long id;
    private long userId;
    private long deptId;

    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "userDeptSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_USER_DEPT")
            }
    )
    @GeneratedValue(generator = "userDeptSequenceGenerator")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "DEPT_ID")
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientSmUserDeptPO that = (OrientSmUserDeptPO) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (deptId != that.deptId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (deptId ^ (deptId >>> 32));
        return result;
    }
}