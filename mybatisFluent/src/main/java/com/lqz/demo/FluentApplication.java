package com.lqz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月12日 18:04:00
 */
@SpringBootApplication
@MapperScan({"com.lqz.demo.mapper"})
public class FluentApplication {
    public static void main(String[] args) {
        SpringApplication.run(FluentApplication.class, args);
    }
}
