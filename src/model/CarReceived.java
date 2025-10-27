package model;

import java.util.ArrayList;

public class CarReceived {
    private int id;
    private String note;
    private Car car;
    private ArrayList<UsedService> usedServices;
    private ArrayList<ServicedTechnician> servicedTechnicians;
    private FixSlot fixSlot;
    public CarReceived() {}
    public CarReceived(int id, String note, Car car) {
        this.id = id;
        this.note = note;
        this.car = car;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<UsedService> getUsedServices() {
        return usedServices;
    }

    public void setUsedServices(ArrayList<UsedService> usedServices) {
        this.usedServices = usedServices;
    }

    public ArrayList<ServicedTechnician> getServiceTechnicians() {
        return servicedTechnicians;
    }
    public void setServiceTechnicians(ArrayList<ServicedTechnician> servicedTechnicians) {
        this.servicedTechnicians = servicedTechnicians;
    }

    public FixSlot getFixSlot() {
        return fixSlot;
    }

    public void setFixSlot(FixSlot fixSlot) {
        this.fixSlot = fixSlot;
    }
    public UsedService getUsedService(Service service) {
        for (UsedService usedService : usedServices) {
            if (usedService.getService().equals(service)) {
                return usedService;
            }
        }
        return null;
    }
}
