/**
 * @Project Name :  base
 * @Package Name :  com.orient.persistent.system
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 4:56 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.persistent.system.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orient.persistent.base.OrientBasePO;
import com.orient.persistent.util.IsDel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :  panduanduan
 * @Description :  系统用户表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_NAME"))
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"roles"})
@ToString(exclude = {"roles"})
public class OrientSmUserPO extends OrientBasePO {
    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "userSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_USER")
            }
    )
    @GeneratedValue(generator = "userSequenceGenerator")
    private long id;

    @Basic
    @Column(name = "USER_NAME")
    private String userName;

    @Basic
    @Column(name = "ALL_NAME")
    private String allName;

    @Basic
    @Column(name = "MOBILE")
    private String mobile;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @Basic
    @Column(name = "IS_DEL")
    @Enumerated(EnumType.ORDINAL)
    private IsDel isDel;

    @Basic
    @Column(name = "CREATE_USER")
    @CreatedBy
    private Long createUser;

    @Basic
    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createTime;

    @Basic
    @Column(name = "UPDATE_USER", updatable = false, nullable = false)
    @LastModifiedBy
    private Long updateUser;

    @Basic
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date updateTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    @Where(clause = "IS_DEL=0")
    private Set<OrientSmRolePO> roles = new HashSet<>();

}