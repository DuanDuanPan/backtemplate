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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :  panduanduan
 * @Description :  角色表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"users"})
@ToString(exclude = {"users"})
public class OrientSmRolePO extends OrientBasePO {
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
    private long id;

    @Basic
    @Column(name = "NAME", unique = true, nullable = false)
    @NonNull
    private String name;

    @Basic
    @Column(name = "DESCR", length = 2000)
    private String descr;

    @Basic
    @Column(name = "IS_DEL", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private IsDel isDel;

    @JsonIgnore
    @JoinTable(name = "SM_ROLE_USER",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Where(clause = "IS_DEL=0")
    private Set<OrientSmUserPO> users = new HashSet<>();
}