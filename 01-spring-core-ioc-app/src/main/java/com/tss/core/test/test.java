package com.tss.core.test;

import com.tss.core.config.AutoConfig;
import com.tss.core.entity.Computer;
import com.tss.core.entity.Harddisk;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
//        Harddisk harddisk=new Harddisk(512);
//        Computer computer=new Computer("HP",harddisk);
//
//        System.out.println(computer);

//        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
//
//        Computer computer=context.getBean("computer", Computer.class);
//
//        System.out.println(computer);

        ApplicationContext context=new AnnotationConfigApplicationContext(AutoConfig.class);

        Computer computer=context.getBean(Computer.class);

        System.out.println(computer);
    }

}
