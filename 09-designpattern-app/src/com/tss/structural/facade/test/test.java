package com.tss.structural.facade.test;

import com.tss.structural.facade.facade.HotelReception;

public class test {
    public static void main(String[] args) {
        HotelReception hotelReception=new HotelReception();
        hotelReception.getIndianMenu();
        hotelReception.getItalianMenu();
    }
}
