package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * mandatory 强制事务
 *
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 10:33:00
 */
public interface MandatoryService {

    @Transactional(propagation = Propagation.MANDATORY)
    Boolean mandatory1(Test2 test2);

    Boolean mandatory2(Test2 test2);

    @Transactional
    Boolean mandatory3(Test2 test2);
}
