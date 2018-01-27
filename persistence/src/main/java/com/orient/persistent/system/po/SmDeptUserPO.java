package com.orient.persistent.system.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "sm_dept_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmDeptUserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "user_id")
    private Integer userId;
}