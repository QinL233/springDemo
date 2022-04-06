package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * mandatory 强制事务
 * 强制上游调用该方法时必须触发事务（如果直接内部调用则无效）
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
