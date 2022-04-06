package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Test2;
import com.lqz.demo.mapper.Test2Mapper;
import com.lqz.demo.service.Test2Service;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2022-04-06
 */
@Service
public class Test2ServiceImpl extends ServiceImpl<Test2Mapper, Test2> implements Test2Service {

    /**
     * 默认事务
     * 隔离界别：required
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required1(Test2 test2) {
        save(test2);
        return true;
    }

    /**
     * 默认事务，错误回滚
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required2(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 方法无事务，调用事务方法不生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required3(Test2 test2) {
        return required2(test2);
    }

    /**
     * 方法有事务，调用事务生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required4(Test2 test2) {
        return required2(test2);
    }

    /**
     * 方法无事务，获取代理对象调用方法生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required5(Test2 test2) {
        Test2ServiceImpl service = Test2ServiceImpl.class.cast(AopContext.currentProxy());
        return service.save(test2);
    }
}
