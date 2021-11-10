package com.lqz.demo.dao.impl;

import com.lqz.demo.dao.base.DataSignOrderDetailTempBaseDao;
import com.lqz.demo.dao.intf.DataSignOrderDetailTempDao;
import com.lqz.demo.entity.SumByDeptWithSign;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DataSignOrderDetailTempDaoImpl: 数据操作接口实现
 * <p>
 * 这只是一个减少手工创建的模板文件
 * 可以任意添加方法和实现, 更改作者和重定义类名
 * <p/>@author Powered By Fluent Mybatis
 */
@Repository
public class DataSignOrderDetailTempDaoImpl extends DataSignOrderDetailTempBaseDao implements DataSignOrderDetailTempDao {
    @Override
    public List<SumByDeptWithSign> sum() {
        return super.listPoJos(SumByDeptWithSign.class,
                super.query()
                        .select
                        .professionDeptName("dept")
                        .sum.realityContractSum("sum")
                        .end()
                        .groupBy.deptName()
                        .end());
    }
}
