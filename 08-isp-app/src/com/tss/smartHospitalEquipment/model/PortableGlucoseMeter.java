package com.tss.smartHospitalEquipment.model;

import com.tss.smartHospitalEquipment.Interface.Loggable;

public class PortableGlucoseMeter extends Equipment implements Loggable {
    public PortableGlucoseMeter(String equipmentId, String status) {
        super(equipmentId, "Portable Glucose Meter", status);
    }

    public void measureGlucose() {
        System.out.println("Glucose measurement completed.");
    }

    @Override
    public void recordActivity(String activity) {
        System.out.println("Log : "+activity);
    }
}
