package com.xls.user.impl;

import com.xls.user.userSupport.AAAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BBBB{
    @Autowired
    @Qualifier(value = "DDDD")
    private AAAA aaaa;

    public void printAAA() {
        aaaa.print();
    }
}
