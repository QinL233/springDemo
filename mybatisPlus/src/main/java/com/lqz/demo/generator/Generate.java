package com.lqz.demo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.assertj.core.util.Lists;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis plus代码生成器
 */
public class Generate {

    //作者
    private static String author = "liaoQinZhou";
    //输出路径
    private static String out_put_dir = "D:\\JetBrains\\project\\springDemo\\mybatisPlus\\src\\main\\java";

    // 数据库配置
    private static String username = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/max_user?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static DbType db_type = DbType.MYSQL;
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";

    //生成的实体类时，忽略表的前缀名: 不需要则置空
    private static String[] entity_ignore_prefix = {""};
    //需要生成的表名
    private static String[] tables = {
            "sys_user"
    };
    //需要排除的表名
    private static String[] excludes = {
            "sys_user"
    };
    //自定义实体类父类
    private static String super_entity = "com.baomidou.demo.TestEntity";
    //自定义实体类父类的公共字段
    private static String[] super_entity_columns = {"test_id"};
    // 自定义需要填充的字段
    private static List<TableFill> table_fill_list = new ArrayList<>();

    //包名，导入使用
    private static String package_path = "/com/lqz/demo";

    //文件输出路径
    private static String project_path = System.getProperty("user.dir");

    private static String java_path = project_path + "/src/main/java" + package_path;
    private static String resource_path = project_path + "/src/main";

    private static String entity_path = java_path + "/entity";
    private static String mapper_path = java_path + "/mapper";
    private static String service_path = java_path + "/service";
    private static String service_impl_path = java_path + "/service/impl";
    private static String controller_path = java_path + "/controller";
    private static String xml_path = resource_path + "/resources/mybatis-mapper" + package_path + "/mapper";

    //文件输出模板
    private static String entity_template = "templates/freemarker/entity.java.ftl";
    private static String xml_template = "templates/freemarker/mapper.xml.ftl";
    private static String mapper_template = "templates/freemarker/mapper.java.ftl";
    private static String service_template = "templates/freemarker/service.java.ftl";
    private static String service_impl_template = "templates/freemarker/serviceImpl.java.ftl";
    private static String controller_template = "templates/freemarker/controller.java.ftl";


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator()
                .setGlobalConfig(globalConfig())
                .setDataSource(dataSourceConfig())
                .setStrategy(strategyConfig())
                .setPackageInfo(packageConfig())
                // 因为使用了自定义模板,所以需要把各项置空否则会多生成一次
                .setTemplate(templateConfig())
                // 使用的模板引擎，如果不是默认模板引擎则需要添加模板依赖到pom
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig());
        mpg.execute();
        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));

    }

    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {
        return new GlobalConfig()
                .setAuthor(author) // 作者
                .setOutputDir(out_put_dir)//输出目录
                .setOpen(false)// 生成文件后打开目录
                .setFileOverride(true)// 文件覆盖
                .setActiveRecord(true)// 开启activeRecord模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap: mapper.xml生成查询映射结果
                .setBaseColumnList(true)// XML ColumnList: mapper.xml生成查询结果列
                //.setSwagger2(true)// swagger注解; 须添加swagger依赖
                .setKotlin(false) //是否生成 kotlin 代码
                /*
                    自定义文件命名，注意 %s 会自动填充表实体属性！
                 */
                // .setEntityName("%sEntity");
                // .setMapperName("%sDao")
                // .setXmlName("%sDao")
                .setServiceName("%sService");//默认是I%sService
        // .setServiceImplName("%sServiceDiy")
        // .setControllerName("%sAction")
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(db_type)// 数据库类型
                .setDriverName(driverClassName)// 连接驱动
                .setUrl(url)// 地址
                .setUsername(username)// 用户名
                .setPassword(password);// 密码
        //.setTypeConvert(new MySqlTypeConvert() {
        //    // 自定义数据库表字段类型转换【可选】
        //    @Override
        //    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        //        System.out.println("转换类型：" + fieldType);
        //        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
        //        //    return DbColumnType.BOOLEAN;
        //        // }
        //        return super.processTypeConvert(globalConfig, fieldType);
        //    }
        //})
    }

    /**
     * 生成策略配置，自定义命名，生成结构
     */
    private static StrategyConfig strategyConfig() {
        return new StrategyConfig()
                // .setCapitalMode(true)// 全局大写命名
                // .setDbColumnUnderline(true)//全局下划线命名
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)// 表字段生成策略：下划线连转驼峰
                .setInclude(tables)// 需要生成的表
                // .setExclude(EXCLUDES)// 需要排除生成的表
                .setTablePrefix(entity_ignore_prefix) // 去除表前缀,此处可以修改为您的表前缀
                //.setSuperEntityClass(super_entity) // 自定义实体父类
                //.setSuperEntityColumns(super_entity_columns)// 自定义实体父类:公共字段
                //.setTableFillList(table_fill_list)//自定义实体父类:私有字段
                // .setSuperMapperClass("com.baomidou.demo.TestMapper") // 自定义 mapper 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService") // 自定义 service 父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")// 自定义 service 实现类父类
                // .setSuperControllerClass("com.baomidou.demo.TestController") // 自定义 controller 父类
                // .setEntityColumnConstant(true) // 【实体】是否生成字段常量（默认 false）
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // 是否启用builder 模式:public User setName(String name) {this.name = name; return this;}
                .setEntityBuilderModel(true)
                // 是否为lombok模型; 需要lombok依赖
                //.setEntityLombokModel(true)
                // 生成实体类字段注解
                .setEntityTableFieldAnnotationEnable(true)
                // controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(false)
                // 生成RestController
                .setRestControllerStyle(true);
    }

    /**
     * 包配置，设置包路径用于导包时使用，路径示例：com.path
     */
    private static PackageConfig packageConfig() {
        String parent = package_path.replace('/', '.').substring(1);
        String entity = entity_path.substring(java_path.length()).replace('/', '.').substring(1);
        String mapper = mapper_path.substring(java_path.length()).replace('/', '.').substring(1);
        String xml = xml_path.substring(resource_path.length()).replace('/', '.').substring(1);
        String service = service_path.substring(java_path.length()).replace('/', '.').substring(1);
        String service_impl = service_impl_path.substring(java_path.length()).replace('/', '.').substring(1);
        String controller = controller_path.substring(java_path.length()).replace('/', '.').substring(1);
        return new PackageConfig()
                //父包名
                .setParent(parent)
                .setModuleName("")
                //结构包
                .setEntity(entity)
                .setMapper(mapper)
                .setXml(xml)
                .setService(service)
                .setServiceImpl(service_impl)
                .setController(controller);
    }

    /**
     * 模板配置
     */
    private static TemplateConfig templateConfig() {
        // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template
        // 使用 copy至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
        // 置空后方便使用自定义输出位置
        return new TemplateConfig()
                .setEntity(null)
                .setXml(null)
                .setMapper(null)
                .setService(null)
                .setServiceImpl(null)
                .setController(null);
    }

    /**
     * 自定义配置
     */
    private static InjectionConfig injectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                // 注入配置
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileCreate(new IFileCreate() {
            // 自定义输出文件
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 检查文件目录，不存在自动递归创建
                File file = new File(filePath);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                // 自定义指定需要覆盖的文件 - 文件结尾名字参照 全局配置 中对各层文件的命名,未修改为默认值
                if (new File(filePath).exists() && filePath.endsWith("Controller.java")) {
                    return false;
                } else {
                    return true;
                }
            }
        }).setFileOutConfigList(
                //指定模板、输出路径
                Lists.newArrayList(
                        new FileOutConfig(entity_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return entity_path + File.separator + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                            }
                        }, new FileOutConfig(xml_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return xml_path + File.separator + tableInfo.getMapperName() + StringPool.DOT_XML;
                            }
                        }, new FileOutConfig(mapper_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return mapper_path + File.separator + tableInfo.getMapperName() + StringPool.DOT_JAVA;
                            }
                        }, new FileOutConfig(service_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return service_path + File.separator + tableInfo.getServiceName() + StringPool.DOT_JAVA;
                            }
                        }, new FileOutConfig(service_impl_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return service_impl_path + File.separator + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
                            }
                        }, new FileOutConfig(controller_template) {
                            @Override
                            public String outputFile(TableInfo tableInfo) {
                                return controller_path + File.separator + tableInfo.getControllerName() + StringPool.DOT_JAVA;
                            }
                        })
        );
    }
}