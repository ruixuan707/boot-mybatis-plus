package com.monco.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: monco
 * @Date: 2019/8/26 17:00
 * @Description:
 */
public class Generator {

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//开启AR模式
                .setAuthor("monco")//设置作者
                //生成路径(一般都是生成在此项目的src/main/java下面)
                .setOutputDir(projectPath + "/src/main/java")
                .setOpen(false)
                .setSwagger2(true) // 加载swagger注解
                .setDateType(DateType.ONLY_DATE) // 指定时间类型为date
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setIdType(IdType.AUTO)//主键策略
                .setServiceName("I%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setServiceImplName("%sServiceImpl")
                .setBaseResultMap(true)//生成resultMap
                .setBaseColumnList(true);//在xml中生成基础列
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/boot_mybatis_plus?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("123456");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setSuperEntityClass("com.monco.entity.BaseEntity") // 指定baseEntity
                .setSuperEntityColumns(new String[]{"id", "status", "deleted", "create_id",
                        "create_date", "update_id", "update_date"}) // 写于父类中的公共字段
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
                .setTablePrefix("sys_")//表名前缀
                .setEntityLombokModel(true)//使用lombok
                .setRestControllerStyle(true)
                .setVersionFieldName("version")
                .setLogicDeleteFieldName("deleted")
                .setControllerMappingHyphenStyle(true)
                .setInclude("sys_user");//逆向工程使用的表

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.monco.staff")//设置包名的parent
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("entity");
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、模板配置
        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String templatePath = "/templates/mapper.xml.ftl";
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mappers/" +
                        "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        autoGenerator.setCfg(injectionConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 7、controller 模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController("/templatesMybatis/controller.java");
        templateConfig.setService("/templatesMybatis/service.java");
        templateConfig.setServiceImpl("/templatesMybatis/serviceImpl.java");
        autoGenerator.setTemplate(templateConfig);

        //6、执行
        autoGenerator.execute();
    }

}
