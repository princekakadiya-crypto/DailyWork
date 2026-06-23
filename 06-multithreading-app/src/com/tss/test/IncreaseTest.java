package com.tss.test;

import com.tss.tasks.increase;

public class IncreaseTest {
    public static void main(String[] args) throws Exception {
        increase increase=new increase(1);
        increase increase2=new increase(1);
        Thread t1= new Thread(()->{
            for (int i=1;i<=10000;i++)
                increase.increment();
        });
        Thread t2= new Thread(()->{
            for (int i=1;i<=10000;i++)
                increase2.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(increase.getCount());
        System.out.println(increase2.getCount());
    }

}
