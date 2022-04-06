package com.lqz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 09:37:00
 */
@SpringBootApplication
//暴露代理对象
@EnableAspectJAutoProxy(exposeProxy = true)
public class TransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class, args);
    }
}
