package com.lqz.demo.dao.intf;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.lqz.demo.entity.DataSignOrderDetailTempEntity;
import com.lqz.demo.entity.SumByDeptWithSign;

import java.util.List;

/**
 * DataSignOrderDetailTempDao: 数据操作接口
 * <p>
 * 这只是一个减少手工创建的模板文件
 * 可以任意添加方法和实现, 更改作者和重定义类名
 * <p/>@author Powered By Fluent Mybatis
 */
public interface DataSignOrderDetailTempDao extends IBaseDao<DataSignOrderDetailTempEntity> {

    List<SumByDeptWithSign> sumDept();
}
