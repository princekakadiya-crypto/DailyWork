package com.tss.smartHospitalEquipment.model;


import com.tss.smartHospitalEquipment.Interface.Calibratable;
import com.tss.smartHospitalEquipment.Interface.DataTransmittable;
import com.tss.smartHospitalEquipment.Interface.Loggable;
import com.tss.smartHospitalEquipment.Interface.ReportGeneratable;

public class LaboratoryAnalyzer extends Equipment implements ReportGeneratable, Calibratable, DataTransmittable, Loggable {
    public LaboratoryAnalyzer(String equipmentId, String status) {
        super(equipmentId, "Laboratory Analyzer", status);
    }

    @Override
    public void calibrate() {
        System.out.println("LaboratoryAnalyzer calibrate");
    }

    @Override
    public void transmitData() {
        System.out.println("LaboratoryAnalyzer transmit Data");
    }

    @Override
    public void generateReport() {
        System.out.println("LaboratoryAnalyzer generate report");
    }

    @Override
    public void recordActivity(String activity) {
        System.out.println("Log : "+activity);
    }
}
