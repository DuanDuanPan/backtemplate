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

import com.orient.common.util.domain.OrientBasePO;
import com.orient.persistent.util.IsDel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author :  panduanduan
 * @Description :  文件表
 * @Creation Date:  2018-01-23 4:56 PM
 */
@Entity
@Table(name = "SM_FILE")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrientSmFilePO extends OrientBasePO {
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
    private Long id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "SUFFIX")
    private String suffix;

    @Basic
    @Column(name = "FINALNAME")
    private String finalname;

    @Basic
    @Column(name = "LOCATION")
    private String location;

    @Basic
    @Column(name = "FILESIZE")
    private long filesize;

    @Basic
    @Column(name = "IS_DEL")
    @Enumerated(EnumType.ORDINAL)
    private IsDel isDel = IsDel.VALID;
}