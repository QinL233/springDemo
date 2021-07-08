package com.lqz.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqz.demo.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-02-04
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> queryAll();
}
