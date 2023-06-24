## SoapCarsshopServer
Using the script from the carsshop.sql attachments, create the carsshop database. And create a SOAP service that, using jdbc, will take dao of objects from tables. Create a client for this service and get data.

## 6. Web service. rest & soap

## Задание 3 

С помощью скрипта из вложений carsshop.sql создать базу данных carsshop. И создать SOAP-сервис, который с помощью jdbc будет брать dao объектов из таблиц. Создать клиента к этому сервису и получить данные.

## Заметки

### Ошибка java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/carsshop_demo

Решалась добавлением 

```
 try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
```

а также части **?autoReconnect=true&useSSL=false** в 


```
 String url = "jdbc:mysql://localhost:3306/carsshop_demo?autoReconnect=true&useSSL=false";
```
