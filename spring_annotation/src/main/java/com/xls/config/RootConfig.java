package com.xls.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 配置 Spring容器，扫描所有的 组件但是不扫描controller
 */
@ComponentScan(value = "com.xls",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
})
public class RootConfig{
}
