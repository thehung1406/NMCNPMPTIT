package model;

public class UsedService {
    private int id;
    private int quantity;
    private int price;
    private Service service;
    public UsedService() {}
    public UsedService(int id, int quantity, int price, Service service) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
