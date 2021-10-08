package com.example.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 切换使用不同的 @EnableTransactionManagement，体验 AdviceMode.ASPECTJ 的强大
 */
@Configuration
@MapperScan("com.example.mapper")
@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.PROXY)
//@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class MybatisConfig {

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
