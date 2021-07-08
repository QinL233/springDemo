package com.lqz.demo.strategy;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Objects;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 15:30:00
 */
@Service
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class ExcelHandler {

    public void execute(String type,InputStream is){
        try {
            ReaderStrategy bean = SpringUtil.getBean(type, ReaderStrategy.class);
            if(Objects.nonNull(bean)){
                bean.read(is);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
