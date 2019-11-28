package com.xls.entry;

import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.stereotype.Component;

public class Cat extends AspectJTypeFilter {


    public Cat(String typePatternExpression, ClassLoader classLoader) {
        super(typePatternExpression, classLoader);
    }


}
