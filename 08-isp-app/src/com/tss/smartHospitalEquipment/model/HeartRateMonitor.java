package com.tss.smartHospitalEquipment.model;

import com.tss.smartHospitalEquipment.Interface.DataTransmittable;
import com.tss.smartHospitalEquipment.Interface.Loggable;
import com.tss.smartHospitalEquipment.Interface.Monitorable;

public class HeartRateMonitor extends Equipment implements Monitorable, DataTransmittable, Loggable {
    public HeartRateMonitor(String equipmentId,  String status) {
        super(equipmentId, "Heart Rate Monitor", status);
    }

    @Override
    public void startMonitoring() {
        System.out.println("Monitoring start");
    }

    @Override
    public void stopMonitoring() {
        System.out.println("Monitoring End");
    }

    @Override
    public void recordActivity(String activity) {
        System.out.println("log : "+activity);
    }

    @Override
    public void transmitData() {
        System.out.println("Transmit data");
    }
}
