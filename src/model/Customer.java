package model;

import java.util.ArrayList;

public class Customer {
    private int id ;
    private String Name ;
    private String Address ;
    private String Tel;
    private String Note;
    private ArrayList<Car> cars;
    public Customer() {};
    public Customer(int id, String name, String address, String tel, String note) {
        this.id = id;
        Name = name;
        Address = address;
        Tel = tel;
        Note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getTel() {
        return Tel;
    }

    public String getNote() {
        return Note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public void setNote(String note) {
        Note = note;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
