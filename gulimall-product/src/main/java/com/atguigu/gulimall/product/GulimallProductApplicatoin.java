package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 * 2.逻辑删除
 *      配置全局的逻辑删除的规则(高版本可以省略)
 *      配置逻辑删除的组件Bean(同上)
 *      给Bean加上逻辑删除注解@TableLogic
 * 3.JSR303
 *    1.给Bean添加校验注解
 *    2.开启校验注解
 *    3.给校验的bean后紧跟一个BindingResult,就可以获取到校验的结果
 * 4.统一的异常处理
 * @ControllerAdvice
 *  1.
 */
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
public class GulimallProductApplicatoin {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplicatoin.class, args);
    }
}
