package com.tss.structural.Adapter.service;

import com.tss.structural.Adapter.Repository.CartRepository;
import com.tss.structural.Adapter.adepter.HatAdepter;
import com.tss.structural.Adapter.model.Biscuit;
import com.tss.structural.Adapter.model.Chocolate;
import com.tss.structural.Adapter.model.Hat;
import com.tss.structural.Adapter.model.IItems;

public class CartService {
    private CartRepository cartRepository=new CartRepository();

    public void start()
    {
        cartRepository.AddToCart(new Biscuit("parle G",5));
        cartRepository.AddToCart(new Chocolate("KitKat",10));
        cartRepository.AddToCart(new HatAdepter(new Hat("a","abc",100,10)));

        displayItem();
        System.out.println("Total price : "+cartRepository.getTotalPrice());

    }
    public void displayItem()
    {
        System.out.printf("%20s %20s%n","Name","Price");
        System.out.println("--------------------------------------------");
        for (IItems item: cartRepository.getCart())
        {
            System.out.printf("%20s %20.2f%n",item.getName(),item.getPrice());
        }
    }
}
