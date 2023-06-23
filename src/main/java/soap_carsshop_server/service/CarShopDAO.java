package soap_carsshop_server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.List;

@WebService
public interface CarShopDAO {

    @WebMethod
    List<String> getAllMarks();

    @WebMethod
    String getMarkById(int id);


}