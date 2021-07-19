package com.lqz.demo.service.impl;

import com.lqz.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月19日 10:53:00
 */
public class AbstractUserServiceImpl implements UserService {

    @Autowired
    private TestService testService;

    @Override
    public String get() {
        return testService.get();
    }

    @Override
    public String query() {
        return get();
    }
}
