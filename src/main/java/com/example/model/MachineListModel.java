package com.example.model;

public class MachineListModel {
    private String InventoryId;
    private String type;
    private String lastTO;
    private String futerTO;

    public MachineListModel(String InventoryId,String type,String lastTO,String futerTO){
        this.futerTO = futerTO;
        this.lastTO = lastTO;
        this.InventoryId = InventoryId;
        this.type = type;
    }
    public MachineListModel(){}

    public String getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(String inventoryId) {
        InventoryId = inventoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastTO() {
        return lastTO;
    }

    public void setLastTO(String lastTO) {
        this.lastTO = lastTO;
    }

    public String getFuterTO() {
        return futerTO;
    }

    public void setFuterTO(String futerTO) {
        this.futerTO = futerTO;
    }
}
