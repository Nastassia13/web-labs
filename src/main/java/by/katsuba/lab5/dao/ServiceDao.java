package by.katsuba.lab5.dao;

import by.katsuba.lab5.entity.Service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ServiceDao {
    List<Service> readServices();

    Service readServiceById(long id);

    boolean insertService(Service service);

    boolean deleteService(Service service);

    List<Service> readServiceBySubscriber(long idSubscriber);
}
