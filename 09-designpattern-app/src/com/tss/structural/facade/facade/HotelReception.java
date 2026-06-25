package com.tss.structural.facade.facade;

import com.tss.structural.facade.model.IHotel;
import com.tss.structural.facade.model.IMenu;
import com.tss.structural.facade.model.IndianHotel;
import com.tss.structural.facade.model.ItalianHotel;

public class HotelReception {
    // instead of creating it in main class create it in facade class and just call the method where it needed
    public void getIndianMenu()
    {
        IHotel indHotel=new IndianHotel();
        IMenu menu= indHotel.getMenu();
        menu.displayMenu();
    }
    public void getItalianMenu()
    {
        IHotel italianHotel=new ItalianHotel();
        IMenu menu= italianHotel.getMenu();
        menu.displayMenu();
    }
}
