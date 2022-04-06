package com.lqz.demo.service;

import com.lqz.demo.entity.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单独事务，强调上游不影响我，而我影响上游
 * 1、单独使用时当作一个事务使用
 * 2、被调用时，上游方法不影响当前事务本身
 * 3、被调用时，触发异常影响上游事务
 * 4、作为单独事务，调用下层事务时同样被下层影响
 *
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Boolean requiresNew4(Test2 test2);


}
