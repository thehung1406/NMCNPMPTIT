package model;

public class ServicedTechnician {
    public int id;
    private Technician technician;
    public ServicedTechnician() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
    public ServicedTechnician(int id, Technician technician) {
        this.id = id;
        this.technician = technician;
    }
}
