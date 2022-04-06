package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 11:21:00
 */
public interface NotSupportedService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Boolean notSupported1(Test2 test2);

    Boolean notSupported2(Test2 test2);

    @Transactional
    Boolean notSupported3(Test2 test2);

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Boolean notSupported4(Test2 test2);
}
