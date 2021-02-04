package com.lqz.demo.controller;

import com.lqz.demo.entity.SysUser;
import com.lqz.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private  SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list(){
        return sysUserService.list();
    }
}
