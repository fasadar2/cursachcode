package com.example.model;

public class DoctorTableModel {

    private String date;
    private String machinename;
    private String cabinet;
    public DoctorTableModel( String date,String machinename,String cabinet){

        this.date = date;
        this.machinename = machinename;
        this.cabinet = cabinet;
    }
    public DoctorTableModel(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMachinename() {
        return machinename;
    }

    public void setMachinename(String machinename) {
        this.machinename = machinename;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
}
