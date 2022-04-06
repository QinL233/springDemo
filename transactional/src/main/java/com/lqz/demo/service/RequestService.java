package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务：默认隔离级别-request
 * 以方法入口的角度如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务
 * 必须是走spring代理对象才可以实现（方法直接内部调用，或非spring实例对象调用都不生效）
 *
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 10:05:00
 */
public interface RequestService {

    @Transactional
    Boolean request1(Test2 test2);

    @Transactional(rollbackFor = Exception.class)
    Boolean request2(Test2 test2);

    Boolean request3(Test2 test2);

    @Transactional
    Boolean request4(Test2 test2);

    @Transactional
    Boolean request5(Test2 test2);
}
