package com.lqz.demo.service.impl;

import com.lqz.demo.MybatisApplication;
import com.lqz.demo.mapper.SysUserMapper;
import com.lqz.demo.module.SysUser;
import com.lqz.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/1/29 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> list = userService.queryAll();
        System.out.println(list);
    }

}
