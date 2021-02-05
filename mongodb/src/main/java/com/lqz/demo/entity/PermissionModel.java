package com.lqz.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:28
 */
public class PermissionModel implements Serializable {

    private static final long serialVersionUID = 7832049723152565800L;
    @Id
    private Long id;
    @Indexed
    private Long nameId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
