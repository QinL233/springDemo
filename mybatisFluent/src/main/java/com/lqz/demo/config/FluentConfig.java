package com.lqz.demo.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年11月10日 15:56:00
 */
@Configuration
public class FluentConfig {
    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
