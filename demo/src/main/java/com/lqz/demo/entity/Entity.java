package com.lqz.demo.entity;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 18:00
 */
public class Entity {
    /*
    @Null：被注释的属性必须为null；
    @NotNull：被注释的属性不能为null；
    @AssertTrue：被注释的属性必须为true；
    @AssertFalse：被注释的属性必须为false；
    @Min：被注释的属性必须大于等于其value值；
    @Max：被注释的属性必须小于等于其value值；
    @Size：被注释的属性必须在其min和max值之间；
    @Pattern：被注释的属性必须符合其regexp所定义的正则表达式；
    @NotBlank：被注释的字符串不能为空字符串；
    @NotEmpty：被注释的属性不能为空；
    @Email：被注释的属性必须符合邮箱格式。
     */

    private String user_name;

    @Override
    public String toString() {
        return "Entity{" +
                "user_name='" + user_name + '\'' +
                '}';
    }
}
