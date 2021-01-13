package com.zhanfan.gulimall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis分页插件配置
 * @author ：zhanfan
 * @date ：Created in 2021/1/13 11:25
 */
@Configuration
@EnableTransactionManagement //开启事务
@MapperScan("com.zhanfan.gulimall.product.dao")
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //请求页面大于最大页后，true：回到首页；false：继续请求，默认false
        paginationInterceptor.setOverflow(true);
        //设置最大单页限制数量：默认500，-1不受限制
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
