package soap_carsshop_server.entity;

public class Order {
    private int id;
    private int carId;
    private int clientId;

    public Order(int id, int carId, int clientId) {
        this.id = id;
        this.carId = carId;
        this.clientId = clientId;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
