package com.xls.spring_annotation_ioc.bean;

import org.springframework.stereotype.Component;

/**
 * 使用包扫描来创建注入bean
 * 直接在注解上加别名
 */
@Component(value = "ccc")
public class Bean17 {
}
