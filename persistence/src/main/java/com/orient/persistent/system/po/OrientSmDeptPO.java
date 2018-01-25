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

import com.orient.persistent.base.OrientBasePO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author :  panduanduan
 * @Description :  部门表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_DEPT", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@EntityListeners(AuditingEntityListener.class)
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
    private long id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "DESCR")
    private String descr;

    @Basic
    @Column(name = "IS_DEL")
    private long isDel;

}