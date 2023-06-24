package soap_carsshop_server.service;

import soap_carsshop_server.util.DatabaseUtil;

import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "soap_carsshop_server.service.CarShopDAO")
public class CarShopDAOImpl implements CarShopDAO {
    private Connection connection;


    public CarShopDAOImpl() {
        connection = DatabaseUtil.getConnection();
    }

    @Override
    public List<String> getAllMarks() {
        List<String> marks = new ArrayList<String>();

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

        try (PreparedStatement statement = connection.prepareStatement(query);
        ) {

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
}
