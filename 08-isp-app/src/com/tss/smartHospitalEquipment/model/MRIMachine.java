package com.tss.smartHospitalEquipment.model;

import com.tss.smartHospitalEquipment.Interface.Calibratable;
import com.tss.smartHospitalEquipment.Interface.Loggable;
import com.tss.smartHospitalEquipment.Interface.ReportGeneratable;

public class MRIMachine extends Equipment implements ReportGeneratable, Calibratable, Loggable {
    public MRIMachine(String equipmentId, String status) {
        super(equipmentId, "MRI Machine", status);
    }

    public void performScan()
    {
        System.out.println("Perform MRI Scan");
    }
    @Override
    public void calibrate() {
        System.out.println("MRI calibrate");
    }

    @Override
    public void generateReport() {
        System.out.println("Generate MRI report");
    }

    @Override
    public void recordActivity(String activity) {
        System.out.println("Log : "+activity);
    }
}
