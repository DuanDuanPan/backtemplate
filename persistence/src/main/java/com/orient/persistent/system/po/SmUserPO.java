package com.orient.persistent.system.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sm_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmUserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "all_name")
    private String allName;

    @Column(name = "user_password")
    private String userPassword;

    @Builder.Default
    @Column(name = "is_del")
    private Integer isDel = 0;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private Integer updateUser;


}