package com.lqz.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月12日 14:15:00
 */
@ApiModel(value = "test", description = "test")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Test {

    private Long id;

    @ApiModelProperty(value = "测试", name = "value", example = "test")
    private String value;
}
