package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Test2;
import com.lqz.demo.mapper.Test2Mapper;
import com.lqz.demo.service.Test2Service;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
     * 事务生效，插入成功
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
     * 事务生效，回滚成功
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
     * 事务无效、错误插入
     * 方法无事务，且直接调用方法不走代理则内部方法事务也不生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required3(Test2 test2) {
        return required2(test2);
    }

    /**
     * 事务生效，回滚成功
     * 方法有事务，调用本方法事务生效，内部方法事务失效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required4(Test2 test2) {
        return required2(test2);
    }

    /**
     * 事务生效、回滚成功
     * 方法无事务，获取代理对象调用方法生效
     * 上游方法会影响到下游的事务
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required5(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        service.required1(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * supports 表示支持事务执行，即根据上游方法判断该方法是否使用事务
     * 单独执行无事务，被事务调用时则根据事务来
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean supports1(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 事务生效，回滚成功
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean supports2(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.supports1(test2);
    }

    /**
     * 事务生效，回滚成功
     * support初始状态当作无事务使用，通过代理调用有事务方法，第二层事务生效，再通过有事务方法调用第三层supports最终事务生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean supports3(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.supports2(test2);
    }

    /**
     * 事务生效，回滚成功
     * 嵌套事务，required存在事务，向下调用包含事务
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean supports4(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.supports3(test2);
    }

    /**
     * 事务生效，方法不执行
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean mandatory1(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 事务生效，方法不执行
     * 本身无事务，直接调用事务会导致事务失效，但是使用代理方法会触发事务
     * 而事务mandatory本身强制上游必须有事务，因此调用失败
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean mandatory2(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.mandatory1(test2);
    }

    /**
     * 事务生效，回滚成功
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean mandatory3(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.mandatory1(test2);
    }

    /**
     * 事务生效，新增成功
     * 单独使用时作为一个事务
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean requiresNew1(Test2 test2) {
        save(test2);
        return true;
    }

    /**
     * 事务生效，回滚成功
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean requiresNew2(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 事务生效，内部插入成功，但是失败的事务会影响到上层事务
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean requiresNew3(Test2 test2) {
        save(test2);
        //插入成功，作为单独一个事务
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.requiresNew1(test2);
        //异常事务，抛出异常导致上游事务触发回滚
        test2.setId(test2.getId() + 1);
        service.requiresNew2(test2);
        return true;
    }

    /**
     * 事务生效，下游对上游的影响不取绝上游是否有事务
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean requiresNew4(Test2 test2) {
        save(test2);
        //插入成功，作为单独一个事务
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.requiresNew1(test2);
        //异常事务，抛出异常导致上游事务触发回滚
        test2.setId(test2.getId() + 1);
        service.requiresNew2(test2);
        return true;
    }

    /**
     * 事务生效，状态为不回滚
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean notSupported1(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 事务生效，下游事务不影响上游
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean notSupported2(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.notSupported1(test2);
    }

    /**
     * 事务生效，上游触发回滚，下游不触发
     * 下游事务不取决于上游是否有事务，且不取绝上游是否报错
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean notSupported3(Test2 test2) {
        save(test2);
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.notSupported1(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 事务生效，上下游都不回滚
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean notSupported4(Test2 test2) {
        save(test2);
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.notSupported1(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 本身可以执行，触发事务，且不回滚
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean never1(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return null;
    }

    /**
     * 触发事务，由于上游存在事务，因此内部方法抛出异常
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean never2(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.never1(test2);
    }

    /**
     * 触发事务，不发生回滚
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean never3(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.never1(test2);
    }

    /**
     * 事务生效
     * @param test2
     * @return
     */
    @Override
    public Boolean nested1(Test2 test2) {
        save(test2);
        return true;
    }

    /**
     * 单独使用事务生效
     * @param test2
     * @return
     */
    @Override
    public Boolean nested2(Test2 test2) {
        save(test2);
        int i = 1 / 0;
        return true;
    }

    /**
     * 无事务的方法调用时，外部不影响内部
     * @param test2
     * @return
     */
    @Override
    public Boolean nested3(Test2 test2) {
        save(test2);

        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.nested1(test2);

        int i = 1/0;
        return true;
    }

    /**
     * 无事务调用时，内外部都不干涉
     * @param test2
     * @return
     */
    @Override
    public Boolean nested4(Test2 test2) {
        save(test2);

        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.nested2(test2);
        return true;
    }

    /**
     * 事务调用时，合并为一个事务
     * @param test2
     * @return
     */
    @Override
    public Boolean nested5(Test2 test2) {
        save(test2);

        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        test2.setId(test2.getId() + 1);
        service.nested1(test2);

        int i=1/0;
        return true;
    }
}
