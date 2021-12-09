package com.lqz.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

@ToString
@Data
@Document(indexName = "pms", shards = 1, replicas = 0)
public class UserModel implements Serializable {

    private static final long serialVersionUID = 6320548148250372657L;

    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String keyword;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String text;
    @Field(type = FieldType.Nested)
    private List<PermissionModel> permissions;
}