package com.lqz.demo.controller;

import com.lqz.demo.entity.SysUser;
import com.lqz.demo.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/page")
    public IPage<SysUser> page(@RequestParam(value = "current", defaultValue = "1") int current,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               @RequestBody(required = false) SysUser entity) {
        IPage<SysUser> page = new Page<>(current, size);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return sysUserService.page(page, wrapper);
    }
}
