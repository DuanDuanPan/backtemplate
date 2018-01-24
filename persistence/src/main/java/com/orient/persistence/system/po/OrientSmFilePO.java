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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description  :  文件表
 * @author       :  panduanduan
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_FILE")
@EntityListeners(AuditingEntityListener.class)
public class OrientSmFilePO {
    private long id;
    private String name;
    private String suffix;
    private String finalname;
    private String location;
    private long filesize;
    private Long createUser;
    private Date createTime;
    private Long updataeUser;
    private Date updateTime;
    private Long isDel;

    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "fileSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_FILE")
            }
    )
    @GeneratedValue(generator = "fileSequenceGenerator")
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
    @Column(name = "SUFFIX")
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Basic
    @Column(name = "FINALNAME")
    public String getFinalname() {
        return finalname;
    }

    public void setFinalname(String finalname) {
        this.finalname = finalname;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "FILESIZE")
    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    @Basic
    @Column(name = "CREATE_USER")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATAE_USER")
    public Long getUpdataeUser() {
        return updataeUser;
    }

    public void setUpdataeUser(Long updataeUser) {
        this.updataeUser = updataeUser;
    }

    @Basic
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "IS_DEL")
    public Long getIsDel() {
        return isDel;
    }

    public void setIsDel(Long isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientSmFilePO that = (OrientSmFilePO) o;

        if (id != that.id) return false;
        if (filesize != that.filesize) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (suffix != null ? !suffix.equals(that.suffix) : that.suffix != null) return false;
        if (finalname != null ? !finalname.equals(that.finalname) : that.finalname != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updataeUser != null ? !updataeUser.equals(that.updataeUser) : that.updataeUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (finalname != null ? finalname.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (int) (filesize ^ (filesize >>> 32));
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updataeUser != null ? updataeUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}