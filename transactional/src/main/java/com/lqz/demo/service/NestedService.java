package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 嵌套事务
 * 外层事务失败时，会回滚内层事务所做的动作。而内层事务操作失败并不会引起外层事务的回滚
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月06日 11:45:00
 */
public interface NestedService {

    @Transactional(propagation = Propagation.NESTED)
    Boolean nested1(Test2 test2);

    @Transactional(propagation = Propagation.NESTED)
    Boolean nested2(Test2 test2);

    Boolean nested3(Test2 test2);

    Boolean nested4(Test2 test2);

    @Transactional
    Boolean nested5(Test2 test2);
}
