package com.tss.smartHospitalEquipment.test;

import com.tss.smartHospitalEquipment.model.*;

public class EquipmentTest {
    public static void main(String[] args) {
        HeartRateMonitor heartRateMonitor=new HeartRateMonitor("123","active");
        heartRateMonitor.startMonitoring();
        heartRateMonitor.stopMonitoring();
        heartRateMonitor.transmitData();
        heartRateMonitor.recordActivity("abc");

        LaboratoryAnalyzer laboratoryAnalyzer=new LaboratoryAnalyzer("124","active");
        laboratoryAnalyzer.calibrate();
        laboratoryAnalyzer.transmitData();
        laboratoryAnalyzer.generateReport();
        laboratoryAnalyzer.recordActivity("xyz");

        MRIMachine mriMachine=new MRIMachine("125","active");
        mriMachine.performScan();
        mriMachine.calibrate();
        mriMachine.generateReport();
        mriMachine.recordActivity("djfb");

        PortableGlucoseMeter portableGlucoseMeter=new PortableGlucoseMeter("126","active");
        portableGlucoseMeter.measureGlucose();
        portableGlucoseMeter.recordActivity("sfv");

        Ventilator ventilator=new Ventilator("127","active");
        ventilator.maintenance();
        ventilator.startMonitoring();
        ventilator.stopMonitoring();
        ventilator.recordActivity("adbf");
    }
}
