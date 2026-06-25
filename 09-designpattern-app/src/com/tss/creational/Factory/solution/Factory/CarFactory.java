package com.tss.creational.Factory.solution.Factory;

import com.tss.creational.Factory.solution.Enumration.CarTypeEnum;
import com.tss.creational.Factory.solution.model.Hyundai;
import com.tss.creational.Factory.solution.model.Maruti;
import com.tss.creational.Factory.solution.model.Car;
import com.tss.creational.Factory.solution.model.Tata;

public class CarFactory {
    public static Car createCar(CarTypeEnum carTypeEnum)
    {
        switch (carTypeEnum)
        {
            case Tata:
                return new Tata("abc",123456);
            case Maruti:
                return new Maruti("pqr",789654);
            case Hyundai:
                return new Hyundai("xyz",987456);
            default:
                return null;
        }
    }
}
