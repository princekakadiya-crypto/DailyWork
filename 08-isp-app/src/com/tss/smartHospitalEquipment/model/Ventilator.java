package com.tss.smartHospitalEquipment.model;

import com.tss.smartHospitalEquipment.Interface.EmergencyAlertCapable;
import com.tss.smartHospitalEquipment.Interface.Loggable;
import com.tss.smartHospitalEquipment.Interface.Maintainable;
import com.tss.smartHospitalEquipment.Interface.Monitorable;

public class Ventilator extends Equipment implements Monitorable, Maintainable, EmergencyAlertCapable, Loggable {
    public Ventilator(String equipmentId, String status) {
        super(equipmentId, "Ventilator", status);
    }

    @Override
    public void triggerEmergencyAlert() {
        System.out.println("Ventilator alert");
    }

    @Override
    public void maintenance() {
        System.out.println("Ventilator under maintenance");
    }

    @Override
    public void startMonitoring() {
        System.out.println("Ventilator start monitoring");
    }

    @Override
    public void stopMonitoring() {
        System.out.println("Ventilator stop monitoring");
    }

    @Override
    public void recordActivity(String activity) {
        System.out.println("Log : "+activity);
    }
}
