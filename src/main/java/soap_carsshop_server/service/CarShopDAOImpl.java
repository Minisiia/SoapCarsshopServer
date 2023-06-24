package soap_carsshop_server.service;

import soap_carsshop_server.entity.Car;
import soap_carsshop_server.entity.Client;
import soap_carsshop_server.util.DatabaseUtil;

import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap_carsshop_server.service.CarShopDAO")
public class CarShopDAOImpl implements CarShopDAO {
    private final Connection connection;


    public CarShopDAOImpl() {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public List<String> getAllMarks() {
        List<String> marks = new ArrayList();
        String query = "SELECT mark FROM marks";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String mark = resultSet.getString("mark");
                marks.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    @Override
    public String getMarkById(int id) {
        String mark = null;
        String query = "SELECT mark FROM marks where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                mark = resultSet.getString("mark");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mark;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList();
        String query = "SELECT * FROM cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMarkId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setPrice(resultSet.getInt("price"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        Car car = new Car();
        String query = "SELECT * FROM cars where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                car.setId(resultSet.getInt("id"));
            car.setMarkId(resultSet.getInt("id"));
            car.setModel(resultSet.getString("model"));
            car.setPrice(resultSet.getInt("price"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList();
        String query = "SELECT * FROM clients";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setAge(resultSet.getInt("age"));
                client.setPhone(resultSet.getString("phone"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client getClientById(int id) {
        Client client = new Client();
        String query = "SELECT * FROM clients where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setAge(resultSet.getInt("age"));
                client.setPhone(resultSet.getString("phone"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<String> getAllOrdersInfo() {
        List<String> orderInfoList = new ArrayList<>();
        String query = "SELECT o.id, c.name, c.age, c.phone, m.mark, ca.model, ca.price " +
                "FROM orders o " +
                "JOIN cars ca ON o.car_id = ca.id " +
                "JOIN clients c ON o.client_id = c.id " +
                "JOIN marks m ON ca.mark_id = m.id";


        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                StringBuilder orderInfo = new StringBuilder();
                orderInfo.append("Order ID: ").append(resultSet.getInt("id")).append(", ");
                orderInfo.append("Client Name: ").append(resultSet.getString("name")).append(", ");
                orderInfo.append("Client Age: ").append(resultSet.getInt("age")).append(", ");
                orderInfo.append("Client Phone: ").append(resultSet.getString("phone")).append(", ");
                orderInfo.append("Car Mark: ").append(resultSet.getString("mark")).append(", ");
                orderInfo.append("Car Model: ").append(resultSet.getString("model")).append(", ");
                orderInfo.append("Car Price: ").append(resultSet.getInt("price"));

                orderInfoList.add(orderInfo.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderInfoList;
    }
}
