package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Detail;
import com.lqz.demo.mapper.DetailMapper;
import com.lqz.demo.service.DetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月07日 17:57:00
 */
@Service
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {
    @Override
    public List<Detail> queryAll() {
        return list();
    }
}
