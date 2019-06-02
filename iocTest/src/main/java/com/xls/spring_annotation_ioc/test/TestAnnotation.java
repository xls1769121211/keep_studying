package com.xls.spring_annotation_ioc.test;

import com.xls.spring_annotation_ioc.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TestAnnotation {

    @Test
    public void Test(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfigure.class);
       Bean16 aaa = (Bean16) context.getBean("aaa");
        System.out.println(aaa);
        Bean16 bbb = (Bean16) context.getBean("bbb");
        System.out.println(bbb);
        Bean17 ccc = (Bean17) context.getBean("ccc");
        System.out.println(ccc);


        Bean18 bean18 = context.getBean("18888",Bean18.class);
        System.out.println("bean18=========="+bean18);

     /*   for (Bean19 bean19 : bean18.getBean19List()) {
            System.out.println(bean19);
        }
*/
        for (Map.Entry<String, Bean19> entry : bean18.getBean19Map().entrySet()) {
            System.out.println(entry);
        }



        Bean21 bean21 = context.getBean("bean21",Bean21.class);
        System.out.println("bean21=========="+bean21);

        Bean21 bean21_1 = context.getBean("bean21",Bean21.class);
        System.out.println("bean21_1=========="+bean21_1);

        System.out.println("bean21_1 == bean21:"+(bean21_1 == bean21));


        for (int i = 0; i < 10; i++) {

            Bean21 bean21_ = context.getBean("bean21",Bean21.class);
            System.out.println("bean21_=========="+bean21_);
        }

        for (int i = 0; i < 10; i++) {

            Bean20 bean20= context.getBean("bean20",Bean20.class);
            System.out.println("bean21_=========="+bean20);
        }
/*

        for (int i = 0; i < 10; i++) {

            Bean23 bean23= context.getBean("bean23",Bean23.class);
            System.out.println("bean23=========="+bean23);
        }
*/




        Bean24 bean24= context.getBean("bean24",Bean24.class);
        System.out.println("bean24=========="+bean24);

        ((AnnotationConfigApplicationContext) context).close();

    }

}
