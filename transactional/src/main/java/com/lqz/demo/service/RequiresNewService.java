package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 10:52:00
 */
public interface RequiresNewService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Boolean requiresNew1(Test2 test2);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Boolean requiresNew2(Test2 test2);

    @Transactional
    Boolean requiresNew3(Test2 test2);


}
