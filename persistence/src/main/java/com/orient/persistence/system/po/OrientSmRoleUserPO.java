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
 * @Description :  角色用户中间表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_ROLE_USER")
public class OrientSmRoleUserPO {
    private long id;
    private long roleId;
    private long userId;

    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "roleUserSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_ROLE_USER")
            }
    )
    @GeneratedValue(generator = "roleUserSequenceGenerator")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientSmRoleUserPO that = (OrientSmRoleUserPO) o;

        if (id != that.id) return false;
        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }
}