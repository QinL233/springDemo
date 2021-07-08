package com.lqz.demo.service.impl;

import com.lqz.demo.anno.Test;
import org.springframework.stereotype.Service;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月19日 10:54:00
 */
@Service
@Test("ddd")
public class TestService {

    public String get() {
        return this.getClass().getName();
    }
}
