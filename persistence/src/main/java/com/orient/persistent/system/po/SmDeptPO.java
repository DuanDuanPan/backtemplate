package com.orient.persistent.system.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "sm_dept")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SmDeptPO", description = "部门持久化对象")
public class SmDeptPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "部门职责描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "上级部门id")
    @Column(name = "pid")
    private Integer pid;
}