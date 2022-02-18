package com.fsocity.framework;


import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;
import java.util.Scanner;

/**
 * MyBatisPlus代码生成器
 * Created by macro on 2020/8/20.
 */
public class MyBatisPlusGenerator {
    // mysql 配置
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/fsocity?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "root";
    // 作者
    private static final String AUTHOR = "Zail";
    // 生成的目标目录
    private static final String OUTPUT_DIR = "./src/main/java";
    // 包名
    private static final String PARENT_PACKAGE_NAME = "com.fsocity.modules";
    // mapper.xml 生成目录
    private static final String MAPPER_OUTPUT_DIR = "./src/main/resources/mapper";
    // templates 目录
    private static final String TEMPLATES_DIR = "/templates/vm";
    
    public static void main(String[] args) {
        String module = scanner("模块名称！");
        String[] tableNames = scanner("表名，多个英文逗号分割").split(",");
        FastAutoGenerator
                .create(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR)           // 设置作者
                            .enableSwagger()         // 开启 swagger 模式
                            .fileOverride()          // 覆盖已生成文件
                            .outputDir(OUTPUT_DIR)   // 指定输出目录
                            .disableOpenDir()        // 取消最后打开文件夹
                    ;
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE_NAME) // 设置父包名
                            .moduleName(module) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, MAPPER_OUTPUT_DIR + "/" + module)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    // 当表名中带*号时可以启用通配符模式
                    if (tableNames.length == 1 && tableNames[0].lastIndexOf('*') == tableNames[0].length() - 1) {
                        String tablePrefix = tableNames[0].substring(0, tableNames[0].length() - 1);
                        builder.likeTable(new LikeTable(tablePrefix, SqlLike.RIGHT));
                    }
                    else {
                        builder.addInclude(tableNames); // 设置需要生成的表名
                    }
                    builder.controllerBuilder()
                            .enableRestStyle(); // 开启RestController风格
                    builder
                            .entityBuilder()
                            .enableLombok() // 开启lombok
                    ;
                    builder
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                    ;
                    builder
                            .mapperBuilder()
                            .enableBaseResultMap() // 开启baseResultMap
                            .enableBaseColumnList()
                    ;
                })
                .templateEngine(new VelocityTemplateEngine())
                .templateConfig(builder -> {
                    builder
                            .controller(TEMPLATES_DIR + "/controller.java.vm")
                            .entity(TEMPLATES_DIR + "/entity.java.vm")
                            .service(TEMPLATES_DIR + "/service.java.vm")
                            .serviceImpl(TEMPLATES_DIR + "/serviceImpl.java.vm")
                            .mapper(TEMPLATES_DIR + "/mapper.java.vm")
                            .mapperXml(TEMPLATES_DIR + "/mapper.xml.vm")
                    ;
                })
                .execute();
    }
    
    /**
     * 读取控制台内容信息
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("请输入" + tip + "："));
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (!(next == null || next.length() == 0)) {
                return next;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}