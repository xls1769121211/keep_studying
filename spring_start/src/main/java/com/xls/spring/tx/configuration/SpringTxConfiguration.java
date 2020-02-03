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
 *  @EnableTransactionManagement 这个注解会导入一个 TransactionManagementConfigurationSelector.class 这个类
 *      1.TransactionManagementConfigurationSelector 最终实现了 ImportSelector，在ioc初始化会执行 selectImports这个方法
 *      按照默认的 AdviceMode.PROXY，TransactionManagementConfigurationSelector这类会执行
 *      -->return new String[] {AutoProxyRegistrar.class.getName(),
 * 						ProxyTransactionManagementConfiguration.class.getName()};
 *      也就是说会在容器中加入 AutoProxyRegistrar.class 和 ProxyTransactionManagementConfiguration.class
 *      2. AutoProxyRegistrar的作用.
 *          AutoProxyRegistrar是一个 ImportBeanDefinitionRegistrar，会在容器初始化过程中执行  registerBeanDefinitions
 *          --> registerBeanDefinitions 会默认注册registerAutoProxyCreatorIfNecessary()-->InfrastructureAdvisorAutoProxyCreator.class
 *          -->InfrastructureAdvisorAutoProxyCreator 找各种增强器包装对象，创建代理对象
 *      3 ProxyTransactionManagementConfiguration 的作用
 *          1）给容器中注册事务增强器 BeanFactoryTransactionAttributeSourceAdvisor
 *              一个是事务注解属性解析器 AnnotationTransactionAttributeSource
 *              一个是事务拦截器 transactionInterceptor --> 保存了事务属性信息，和事务管理器信息，其实是一个 MethodInterceptor，当代理对象执行
 *              方法的时候 执行拦截器链，这个事务拦截器会工作
 *              -->invokeWithinTransaction 最后会执行这个方法
 *                      获取事务属性
 *                      获取事务管理器 默认按照类型获取 defaultTransactionManager = this.beanFactory.getBean(PlatformTransactionManager.class);
 *                  TransactionInfo txInfo = createTransactionIfNecessary(tm, txAttr, joinpointIdentification);开启事务
 * 			        Object retVal;
 * 			        try {
 * 				       retVal = invocation.proceedWithInvocation();执行方法
 * 		        	}
 * 			        catch (Throwable ex) {
 * 				      // target invocation exception
 * 				       completeTransactionAfterThrowing(txInfo, ex);//出现异常回滚事务
 * 				      throw ex;
 * 			        }
 *			        commitTransactionAfterReturning(txInfo);//提交事务
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
