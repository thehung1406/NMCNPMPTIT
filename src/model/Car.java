package model;

public class Car  {
    private int id ;
    private String NumberPlate;
    private String Model;
    private String Make;
    private String Description;

    public Car() {}
    public Car(int id, String numberPlate, String model, String make, String description) {
        this.id = id;
        NumberPlate = numberPlate;
        Model = model;
        Make = make;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public String getModel() {
        return Model;
    }

    public String getMake() {
        return Make;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setMake(String make) {
        Make = make;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
