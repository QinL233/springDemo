package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.SysUser;
import com.lqz.demo.mapper.SysUserMapper;
import com.lqz.demo.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-02-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public List<SysUser> queryAll() {
        return list();
    }
}
