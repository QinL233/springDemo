package com.lqz.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqz.demo.entity.Detail;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-02-04
 */
@DS("doris")
public interface DetailMapper extends BaseMapper<Detail> {

}
