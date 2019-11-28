package com.xls.configuration;

import com.xls.entry.Mouse;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现 ImportBeanDefinitionRegistrar这个接口手动导入bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry current bean definition registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition beanDefinition = new RootBeanDefinition(Mouse.class);
        //注册beanDefinition
        registry.registerBeanDefinition("mousexls",beanDefinition);
    }
}
