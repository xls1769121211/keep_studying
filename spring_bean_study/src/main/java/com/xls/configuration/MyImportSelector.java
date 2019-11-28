package com.xls.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义导入bean 过滤规则
 *
 * 返回要导入的 bean的names,全类名 com.xls.entry.KeyBoard
 * 	 * Select and return the names of which class(es) should be imported based on
 * 	 * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
 */
public class MyImportSelector implements ImportSelector{


    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        String className = annotationMetadata.getClassName();
        System.out.println("MyImportSelector------>"+className);

        return new String[]{"com.xls.entry.KeyBoard"};
    }
}
