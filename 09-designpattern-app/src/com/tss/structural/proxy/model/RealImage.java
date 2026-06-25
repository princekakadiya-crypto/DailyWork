package com.tss.structural.proxy.model;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImage();
    }

    public void loadImage()
    {
        System.out.println("File is loading..");
    }

    @Override
    public void display() {
        System.out.println(fileName);
    }
}
