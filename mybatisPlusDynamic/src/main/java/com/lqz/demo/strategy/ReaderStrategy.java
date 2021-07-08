package com.lqz.demo.strategy;

import java.io.InputStream;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 15:33:00
 */
public interface ReaderStrategy {
    void read(InputStream is);
}
