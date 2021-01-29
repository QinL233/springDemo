package com.lqz.demo.service.impl;

import com.lqz.demo.mapper.SysUserMapper;
import com.lqz.demo.module.SysUser;
import com.lqz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/1/29 14:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> queryAll() {
        return userMapper.selectList(null);
    }
}
