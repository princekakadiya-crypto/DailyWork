package com.tss.smartHospitalEquipment.model;

public abstract class Equipment {
    protected String equipmentId;
    protected String name;
    protected String status;

    public Equipment(String equipmentId, String name, String status) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println(name + " Status: " + status);
    }

    public abstract void recordActivity(String activity);
}
