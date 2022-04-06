package com.lqz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author liaoQinZhou
 * @since 2022-04-06
 */
@TableName("test_2")
@ApiModel(value="Test2对象", description="")
public class Test2 extends Model<Test2> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("s1")
    private String s1;

    @TableField("s2")
    private String s2;

    @TableField("s3")
    private String s3;

    public Integer getId() {
        return id;
    }

    public Test2 setId(Integer id) {
        this.id = id;
        return this;
    }
    public String gets1() {
        return s1;
    }

    public Test2 sets1(String s1) {
        this.s1 = s1;
        return this;
    }
    public String gets2() {
        return s2;
    }

    public Test2 sets2(String s2) {
        this.s2 = s2;
        return this;
    }
    public String gets3() {
        return s3;
    }

    public Test2 sets3(String s3) {
        this.s3 = s3;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Test2{" +
            "id=" + id +
            ", s1=" + s1 +
            ", s2=" + s2 +
            ", s3=" + s3 +
        "}";
    }
}
