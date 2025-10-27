package model;

import java.sql.Time;

public class Service {
    private int id;
    private String Name;
    private int UnitPrice;
    private Time ServiceTime;
    public Service() {}
    public Service(int id, String name, int unitPrice, Time serviceTime) {
        this.id = id;
        Name = name;
        UnitPrice = unitPrice;
        ServiceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }
    public Time getServiceTime() {
        return ServiceTime;
    }

    public void setServiceTime(Time serviceTime) {
        ServiceTime = serviceTime;
    }

}
