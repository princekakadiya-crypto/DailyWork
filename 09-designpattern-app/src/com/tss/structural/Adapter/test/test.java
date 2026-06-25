package com.tss.structural.Adapter.test;

import com.tss.structural.Adapter.adepter.HatAdepter;
import com.tss.structural.Adapter.model.Biscuit;
import com.tss.structural.Adapter.model.Chocolate;
import com.tss.structural.Adapter.model.Hat;
import com.tss.structural.Adapter.model.IItems;
import com.tss.structural.Adapter.service.CartService;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        CartService cartService=new CartService();
        cartService.start();
    }
}
