package com.lqz.demo.service;

import com.lqz.demo.mapper.SysUserMapper;
import com.lqz.demo.module.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private SysUserMapper userMapper;

    public List<SysUser> queryAll() {
        return userMapper.selectList(null);
    }

    public List<SysUser> queryPage() {
        return null;
    }
}
