package com.lqz.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:28
 */
@ToString
@Data
public class PermissionModel implements Serializable {

    private static final long serialVersionUID = 7832049723152565800L;
    @Id
    private Long id ;
    @Field(type = FieldType.Keyword)
    private String name;
}
