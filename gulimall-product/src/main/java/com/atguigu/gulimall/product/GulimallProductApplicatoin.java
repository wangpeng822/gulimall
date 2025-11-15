package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.整合Mybatis-plus
 *  1).导入依赖
 *  2).配置
 *     1.配置数据源
 *       1).导入数据库驱动
 *       2).在application.yml配置数据源相关信息
 *     2).配置Mybatis-plus
 *       1).在启动类添加@MapperScan注解扫描mapper接口
 *       2).告诉Mybatis-plus 映射文件位置
 *
 */
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplicatoin {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplicatoin.class, args);
    }
}
