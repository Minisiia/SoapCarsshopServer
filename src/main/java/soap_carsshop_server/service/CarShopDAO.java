package soap_carsshop_server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

import soap_carsshop_server.entity.Car;
import soap_carsshop_server.entity.Client;

@WebService
public interface CarShopDAO {

    @WebMethod
    List<String> getAllMarks();

    @WebMethod
    String getMarkById(int id);

    @WebMethod
    List<Car> getAllCars();

    @WebMethod
    Car getCarById(int id);

    @WebMethod
    List<Client> getAllClients();

    @WebMethod
    Client getClientById(int id);

    @WebMethod
    List<String> getAllOrdersInfo();

}