package com.xls.spring.ext.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Spring  BeanFactoryPostProcessor 扩展原理
 *  BeanFactoryPostProcessor 调用时机：在BeanFactory标准初始化之后调用，这时所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建，能干什么：来定制和修改BeanFactory的内容，如覆盖或添加属性
 *  BeanPostProcessor bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *
 * 在 ioc 容器启动过程中
 * 执行 invokeBeanFactoryPostProcessors(beanFactory); 初始化所有的beanFactoryPostProcessor
 *     --> PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *     --> invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);
 *     -->postProcessor.postProcessBeanFactory(beanFactory),调用自己实现的 beanFactoryPostProcessor
 *
 *
 * Spring BeanDefinitionPostProcessor 扩展原理
 *  BeanDefinitionPostProcessor 继承了 BeanFactoryPostProcessor，这时所有的bean定义还没有加载到beanFactory,是在BeanFactoryPostProcessor注册之前执行 postProcessBeanDefinitionRegistry
 *  在 ioc 容器启动过程中
 * 执行 invokeBeanFactoryPostProcessors(beanFactory); 初始化所有的beanFactoryPostProcessor
 *   --> PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *   --> invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
 *   --> invokeBeanFactoryPostProcessors(registryProcessors, beanFactory)
 */
@Configuration
@ComponentScan("com.xls.spring.ext")
public class SpringExtConfiguration{
}
