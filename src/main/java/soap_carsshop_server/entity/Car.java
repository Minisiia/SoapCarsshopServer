package soap_carsshop_server.entity;

public class Car {
    private int id;
    private int markId;
    private String model;
    private int price;

    public Car(int id, int markId, String model, int price) {
        this.id = id;
        this.markId = markId;
        this.model = model;
        this.price = price;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

