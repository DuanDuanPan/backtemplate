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
 * @Description :  角色表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class OrientSmRolePO {
    private long id;
    private String name;
    private String descr;
    private long isDel;

    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "roleSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_ROLE")
            }
    )
    @GeneratedValue(generator = "roleSequenceGenerator")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCR")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Basic
    @Column(name = "IS_DEL")
    public long getIsDel() {
        return isDel;
    }

    public void setIsDel(long isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientSmRolePO that = (OrientSmRolePO) o;

        if (id != that.id) return false;
        if (isDel != that.isDel) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (int) (isDel ^ (isDel >>> 32));
        return result;
    }
}