package soap_carsshop_server;

import soap_carsshop_server.service.CarShopDAO;
import soap_carsshop_server.service.CarShopDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarShopDAO carShopDAO = new CarShopDAOImpl();
        List<String> marks = carShopDAO.getAllMarks();
        System.out.println("Марки автомобилей:");
        for (String mark : marks) {
            System.out.println(mark);
        }
        System.out.println(carShopDAO.getMarkById(1));
    }
}
