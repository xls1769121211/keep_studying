package com.xls.spring.tx.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务学习
 * 1.搭建环境，配置数据源，导入驱动，使用jdbcTemplate操作数据库
 * 2.在操作方法加上@Transactional，并且要在配置类上加入@EnableTransactionManagement
 * 3.一定要注册事务管理器，
 * 4.原理：
 *
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.xls.spring.tx")
public class SpringTxConfiguration{

    /**
     * 注入数据源
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        return dataSource;
    }

    /**
     * 注入jdbcTemplate
     */

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //这里调用方法不是真的调用方法，而是在spring ioc容器中去寻找该方法返回的bean
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    /**
     * 事务管理器
     */
    @Bean
    public PlatformTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return  new DataSourceTransactionManager(dataSource());
    }

}
