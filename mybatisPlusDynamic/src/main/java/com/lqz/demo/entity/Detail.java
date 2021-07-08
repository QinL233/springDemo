package com.lqz.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月07日 17:53:00
 */
@Data
@TableName("detail")
public class Detail extends Model<Detail> {

    private String dateDay;

    private Integer dateHour;

    private String account;

    private String planId;

    private String unitId;

    private String plan;

    private String unit;

    private Long display;

    private Long click;

    private String clickRate;

    private Float clickAverPrice;

    private Float submit;

    private Float dial;

    private Float remain;

    private Float consult;

    private Float consult2;
}
