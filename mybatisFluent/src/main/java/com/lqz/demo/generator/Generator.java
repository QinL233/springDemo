package com.lqz.demo.generator;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 09:47:00
 */
public class Generator {
    static final String url = "jdbc:mysql://192.168.71.129:3306/max_user?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";

    public static void main(String[] args) {
        FileGenerator.build(Abc.class);
    }

    @Tables(
            /** 数据库连接信息 **/
            url = url, username = "root", password = "password",
            /** Entity类parent package路径 **/
            basePack = "cn.org.fluent.mybatis.springboot.demo",
            /** Entity代码源目录 **/
            srcDir = "src/main/java",
            /** Dao代码源目录 **/
            daoDir = "src/main/java",
            /** 如果表定义记录创建，记录修改，逻辑删除字段 **/
//            gmtCreated = "gmt_create", gmtModified = "gmt_modified", logicDeleted = "is_deleted",
            /** 需要生成文件的表 **/
            tables = @Table(value = {"your_table"})
    )
    static class Abc {
    }

}