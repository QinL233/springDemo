package com.lqz.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年11月10日 15:43:00
 */
@Data
public class SumByDeptWithSign {

    private String dept;

    private BigDecimal sum;
}
