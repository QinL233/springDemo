package com.lqz.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * DataSignOrderDetailTempEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "data_sign_order_detail_temp",
    schema = "visual"
)
public class DataSignOrderDetailTempEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   */
  @TableId("id")
  private Integer id;

  /**
   * 打款到账时间
   */
  @TableField("accounting_time")
  private Date accountingTime;

  /**
   * 账户id
   */
  @TableField("acct_id")
  private String acctId;

  /**
   * 用户名
   */
  @TableField("acct_name")
  private String acctName;

  /**
   * 合同归档时间
   */
  @TableField("archived_time")
  private Date archivedTime;

  /**
   * 开始时间
   */
  @TableField("begin_time")
  private Date beginTime;

  /**
   * 频道
   */
  @TableField("channel")
  private String channel;

  /**
   * 频道资源
   */
  @TableField("channel_resource")
  private String channelResource;

  /**
   * 公司名称
   */
  @TableField("company_name")
  private String companyName;

  /**
   * 合同号
   */
  @TableField("contract_no")
  private String contractNo;

  /**
   * 合同金额
   */
  @TableField("contract_sum")
  private BigDecimal contractSum;

  /**
   * 顾问
   */
  @TableField("counselor")
  private String counselor;

  /**
   */
  @TableField("create_time")
  private Date createTime;

  /**
   * 客户名称
   */
  @TableField("customer_name")
  private String customerName;

  /**
   * 部门
   */
  @TableField("dept_name")
  private String deptName;

  /**
   * 折扣率
   */
  @TableField("discount_ratio")
  private String discountRatio;

  /**
   * 结束时间
   */
  @TableField("end_time")
  private Date endTime;

  /**
   * 大部门
   */
  @TableField("first_dept_name")
  private String firstDeptName;

  /**
   * 新续约
   */
  @TableField("is_extension")
  private String isExtension;

  /**
   * 是否分期
   */
  @TableField("is_installment")
  private String isInstallment;

  /**
   * 投放端
   */
  @TableField("launch")
  private String launch;

  /**
   * 投放状态
   */
  @TableField("launch_status")
  private String launchStatus;

  /**
   * 投放关键词
   */
  @TableField("launch_word")
  private String launchWord;

  /**
   * 客户经理
   */
  @TableField("manager_name")
  private String managerName;

  /**
   * 招商归属
   */
  @TableField("merchants_affiliation")
  private String merchantsAffiliation;

  /**
   * 招商等级
   */
  @TableField("merchants_level")
  private String merchantsLevel;

  /**
   * 招商项目
   */
  @TableField("merchants_project")
  private String merchantsProject;

  /**
   * 中间商
   */
  @TableField("middleman")
  private String middleman;

  /**
   * 订单状态
   */
  @TableField("order_status")
  private String orderStatus;

  /**
   * 订单类型
   */
  @TableField("order_type")
  private String orderType;

  /**
   * 定向
   */
  @TableField("orient")
  private String orient;

  /**
   * 产品
   */
  @TableField("product")
  private String product;

  /**
   * 产品接口
   */
  @TableField("product_impl")
  private String productImpl;

  /**
   * 产品线
   */
  @TableField("product_type")
  private String productType;

  /**
   * 行业部门
   */
  @TableField("profession_dept_name")
  private String professionDeptName;

  /**
   * 行业群组
   */
  @TableField("profession_group_name")
  private String professionGroupName;

  /**
   * 实际合同金额
   */
  @TableField("reality_contract_sum")
  private BigDecimal realityContractSum;

  /**
   * 记录编号
   */
  @TableField("record_no")
  private String recordNo;

  /**
   * 退款金额
   */
  @TableField("refund_sum")
  private BigDecimal refundSum;

  /**
   * 备注
   */
  @TableField("remark")
  private String remark;

  /**
   * 实际售卖人
   */
  @TableField("salesman")
  private String salesman;

  /**
   * 售卖方式
   */
  @TableField("sell_mode")
  private String sellMode;

  /**
   * 签售类型
   */
  @TableField("sign_sale_type")
  private String signSaleType;

  /**
   * 签约时间
   */
  @TableField("sign_time")
  private Date signTime;

  /**
   * 特殊阶段
   */
  @TableField("special_stage")
  private String specialStage;

  /**
   * 客户SSG一级行业
   */
  @TableField("ssg_primary_profession")
  private String ssgPrimaryProfession;

  /**
   * 客户SSG二级行业
   */
  @TableField("ssg_second_profession")
  private String ssgSecondProfession;

  /**
   * 体系
   */
  @TableField("system_name")
  private String systemName;

  /**
   */
  @TableField("update_time")
  private Date updateTime;

  @Override
  public final Class entityClass() {
    return DataSignOrderDetailTempEntity.class;
  }
}
