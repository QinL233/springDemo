package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 本身不带事务，由上游决定是否该方法是否使用事务
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 10:19:00
 */
public interface SupportsService {

    @Transactional(propagation = Propagation.SUPPORTS)
    Boolean supports1(Test2 test2);

    @Transactional
    Boolean supports2(Test2 test2);

    @Transactional(propagation = Propagation.SUPPORTS)
    Boolean supports3(Test2 test2);

    @Transactional
    Boolean supports4(Test2 test2);
}
