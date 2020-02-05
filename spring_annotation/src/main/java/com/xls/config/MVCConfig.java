package com.xls.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC容器，只扫描controller
 *
 * //mvc定制开发
 * 1 注解 @EnableWebMvc 开启mvc config
 * 2 继承 WebMvcConfigurerAdapter(已过时) 推荐使用WebMvcConfigurationSupport
 *
 *
 */
@ComponentScan(value = "com.xls",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
},useDefaultFilters = false)
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter{


    /**
     * 配置视图解析器
     * 默认jsp 页面都是从 /WEB-INF/寻找
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
      //  super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/aaa/",".jsp");

    }
}
