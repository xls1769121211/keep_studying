package com.xls.configuration;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

public class MyFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
       //获取类的metadata,包括一些类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String className = classMetadata.getClassName();

        System.out.println("MyFilter------->"+className);
        //类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //当前类所有的注解类型
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        for (String annotationType : annotationTypes) {
            System.out.println("MyFilter------->"+annotationType);
        }

        return className.contains("Car");
    }
}
