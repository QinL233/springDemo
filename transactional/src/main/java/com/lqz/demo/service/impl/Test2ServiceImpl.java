package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Test2;
import com.lqz.demo.mapper.Test2Mapper;
import com.lqz.demo.service.Test2Service;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
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
     * 事务生效，回滚成功
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
     * 事务生效、回滚成功
     * 方法无事务，获取代理对象调用方法生效
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean required5(Test2 test2) {
        Test2Service service = Test2Service.class.cast(AopContext.currentProxy());
        return service.required2(test2);
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
        return supports1(test2);
    }

    /**
     * 事务失效，错误插入
     * support初始状态当作无事务使用，需要上游决定
     *
     * @param test2
     * @return
     */
    @Override
    public Boolean supports3(Test2 test2) {
        return supports2(test2);
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
        return supports3(test2);
    }

    /**
     * 事务生效，回滚成功
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
     * 本身无事务，直接调用事务会导致事务失效，但是使用代理方法会触发事务
     * 而事务mandatory本身强制上游必须有事务，因此调用失败
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
        return mandatory1(test2);
    }
}
