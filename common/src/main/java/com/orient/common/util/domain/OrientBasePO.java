/**
 * @Project Name :  backtemplate
 * @Package Name :  com.orient.persistent.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 10:04 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.common.util.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author :  panduanduan
 * @Description :  base persistent object with lombok
 * @Creation Date:  2018-01-24 10:04 PM
 */
@MappedSuperclass
@Data
public class OrientBasePO extends AbstractPersistable<Long> implements Serializable {

    @Transient
    private String cacheKey = "orient-po";

    @Basic
    @Column(name = "CREATE_USER")
    @CreatedBy
    protected Long createUser;

    @Basic
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createTime;

    @Basic
    @Column(name = "UPDATE_USER")
    @LastModifiedBy
    protected Long updateUser;

    @Basic
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updateTime;
}