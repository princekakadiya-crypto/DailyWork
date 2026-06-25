package com.tss.structural.proxy.proxy;

import com.tss.structural.proxy.model.Image;
import com.tss.structural.proxy.model.RealImage;

public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage=null;
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage==null)
        {
            realImage=new RealImage(fileName);
            realImage.display();
            return;
        }
        realImage.display();
    }
}
