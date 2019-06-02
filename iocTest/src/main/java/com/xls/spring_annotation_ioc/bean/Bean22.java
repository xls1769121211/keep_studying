package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *注解方式实现bean的作用域
 * @lazy 实现bean的懒加载
 */
@Component
@Scope(value = "prototype")

public  class Bean22 {




}
