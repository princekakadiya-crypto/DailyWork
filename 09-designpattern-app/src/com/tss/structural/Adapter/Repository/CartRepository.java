package com.tss.structural.Adapter.Repository;

import com.tss.structural.Adapter.model.IItems;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    List<IItems> items=new ArrayList<>();

    public void AddToCart(IItems item)
    {
        items.add(item);
    }

    public List<IItems> getCart()
    {
        return items;
    }
    public double getTotalPrice()
    {
        double price=0;
        for (IItems item:items)
            price+=item.getPrice();
        return price;
    }
}
