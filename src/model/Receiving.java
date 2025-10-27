package model;

import java.util.ArrayList;
import java.util.Date;

public class Receiving {
    private int id;
    private Date ReceivingDate;
    private String Note;
    private User user;
    private Customer customer;
    private ArrayList<CarReceived> carReceiveds;
    public Receiving() {}
    public Receiving(int id, Date receivingDate, String note) {
        this.id = id;
        ReceivingDate = receivingDate;
        Note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceivingDate() {
        return ReceivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        ReceivingDate = receivingDate;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<CarReceived> getCarReceiveds() {
        return carReceiveds;
    }
    public void setCarReceiveds(ArrayList<CarReceived> carReceiveds) {
        this.carReceiveds = carReceiveds;
    }

    public CarReceived getCarReceived(String numberPlate) {
        for(CarReceived car : carReceiveds){
            if(numberPlate.equals(car.getCar().getNumberPlate())){
                return car;
            }
        }
        return null;
    }
}
