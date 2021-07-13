package com.lqz.demo.entity;


import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

public class UserModel implements Serializable {

    private static final long serialVersionUID = 6320548148250372657L;

    @Id
    private Long id;
    private String name;
    private List<PermissionModel> permissions;

    public UserModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionModel> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionModel> permissions) {
        this.permissions = permissions;
    }
}