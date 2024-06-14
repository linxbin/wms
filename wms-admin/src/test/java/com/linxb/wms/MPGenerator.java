package com.linxb.wms;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MPGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/wms?serverTimezone=GMT%2B8&useSSL=false",
                        "root",
                        "123456")
                .globalConfig(builder -> builder.author("linxb") // 设置作者
                        .outputDir(System.getProperty("user.dir") + "/wms-admin/src/main/java") // 输出目录
                        .disableOpenDir())
                .packageConfig(builder -> {
                    builder.parent("com.linxb.wms.basis") // 设置父包名
                            .entity("domain.model") // 设置实体类包名
                            .mapper("mapper") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("mappers"); // 设置 Mapper XML 文件包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("storehouse_area", "storehouse_location", "supplier", "customer", "supplier", "settlement_company") // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
}
