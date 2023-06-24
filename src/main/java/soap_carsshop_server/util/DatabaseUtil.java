package soap_carsshop_server.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    public static Connection getConnection() {
        Connection connection = null;

        // Установите соответствующие значения для подключения к базе данных
        String url = "jdbc:mysql://localhost:3306/carsshop_demo?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "root";

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}