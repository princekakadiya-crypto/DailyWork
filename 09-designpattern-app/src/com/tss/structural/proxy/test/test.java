package com.tss.structural.proxy.test;

import com.tss.structural.proxy.proxy.ProxyImage;

public class test {
    public static void main(String[] args) {
        ProxyImage proxyImage=new ProxyImage("abc.jpg");
        proxyImage.display();
        proxyImage.display();
    }
}
