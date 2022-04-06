package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 永不执行事务，上游不能为事务
 *
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 11:36:00
 */
public interface NeverService {

    @Transactional(propagation = Propagation.NEVER)
    Boolean never1(Test2 test2);

    @Transactional
    Boolean never2(Test2 test2);

    Boolean never3(Test2 test2);
}
