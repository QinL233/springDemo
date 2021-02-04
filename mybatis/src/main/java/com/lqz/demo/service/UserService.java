package com.lqz.demo.service;

import com.lqz.demo.mapper.SysUserMapper;
import com.lqz.demo.module.SysUser;
import com.lqz.demo.module.SysUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private SysUserMapper userMapper;

    public List<SysUser> queryAll() {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<SysUser> users = userMapper.selectByExample(example);
        return users;
    }

    public List<SysUser> queryPage() {
        return null;
    }
}
