package com.lqz.demo.module;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -1557825253663684368L;
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String moblie;
    private String email;
    private String avatar;
    private Integer createUser;
    private Integer updateUser;
    private Date createTime;
    private Date updateTime;
    private Date validTime;
    private String validFlag;
}