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
import com.orient.common.util.domain.OrientBasePO;
import com.orient.persistent.util.IsDel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :  panduanduan
 * @Description :  部门表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_DEPT", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "IS_DEL=0")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrientSmDeptPO extends OrientBasePO {
    @Id
    @Column(name = "ID")
    @GenericGenerator(
            name = "deptSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "SEQ_SM_DEPT")
            }
    )
    @GeneratedValue(generator = "deptSequenceGenerator")
    private Long id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "DESCR")
    private String descr;

    @Basic
    @Column(name = "IS_DEL")
    @Enumerated(EnumType.ORDINAL)
    private IsDel isDel = IsDel.VALID;

    @JsonIgnore
    @ManyToMany(mappedBy = "depts", fetch = FetchType.EAGER)
    @Where(clause = "IS_DEL=0")
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<OrientSmUserPO> users = new HashSet<>();

}