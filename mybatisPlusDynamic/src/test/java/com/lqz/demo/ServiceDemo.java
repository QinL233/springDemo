package com.lqz.demo;

import com.lqz.demo.entity.Detail;
import com.lqz.demo.entity.SysUser;
import com.lqz.demo.service.DetailService;
import com.lqz.demo.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月07日 17:36:00
 */
@SpringBootTest
public class ServiceDemo {
    @Autowired
    private SysUserService userService;
    @Autowired
    private DetailService detailService;

    @Test
    public void userTest() {
        List<SysUser> users = userService.queryAll();
        System.out.println(users);
    }

    @Test
    public void detailTest(){
        List<Detail> details = detailService.queryAll();
        System.out.println(details);
    }
}
