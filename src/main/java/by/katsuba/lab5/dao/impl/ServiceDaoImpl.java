package by.katsuba.lab5.dao.impl;

import by.katsuba.lab5.dao.ServiceDao;
import by.katsuba.lab5.entity.Service;
import by.katsuba.lab5.entity.Service_;
import by.katsuba.lab5.entity.Subscriber_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Class ServiceDao for getting data about services from db
 *
 * @author Nastassia Katsuba
 * @version 1.0
 */
@Stateless
public class ServiceDaoImpl implements ServiceDao {
    private EntityManager manager;

    public ServiceDaoImpl() {
        manager = Persistence.createEntityManagerFactory("station").createEntityManager();
    }

    /**
     * Reading all services
     *
     * @return list of services
     */
    @Override
    public List<Service> readServices() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Service> cq = cb.createQuery(Service.class);
        Root<Service> root = cq.from(Service.class);
        cq.select(root);
        List<Service> services = manager.createQuery(cq).getResultList();
        return services;
    }

    /**
     * Reading service by id
     *
     * @param id - id
     * @return service
     */
    @Override
    public Service readServiceById(long id) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Service> cq = cb.createQuery(Service.class);
        Root<Service> root = cq.from(Service.class);
        cq.where(cb.equal(root.get(Service_.id), id));
        Service service = (Service) manager.createQuery(cq).getResultList();
        return service;
    }

    /**
     * Inserting new service
     *
     * @param service - service
     * @return true if insert successfully, false if otherwise
     */
    @Override
    public boolean insertService(Service service) {
        boolean check = true;
        manager.persist(service);
        return check;
    }

    /**
     * Deleting service
     *
     * @param service - service
     * @return true if delete successfully, false if otherwise
     */
    @Override
    public boolean deleteService(Service service) {
        boolean check = true;
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaDelete<Service> cd = cb.createCriteriaDelete(Service.class);
        Root<Service> root = cd.from(Service.class);
        cd.where(cb.equal(root.get(Service_.id), service.getId()));
        manager.createQuery(cd).executeUpdate();
        return check;
    }

    /**
     * Reading subscriber's services by his id
     *
     * @param idSubscriber - subscriber's id
     * @return list of services
     */
    @Override
    public List<Service> readServiceBySubscriber(long idSubscriber) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Service> cq = cb.createQuery(Service.class);
        Root<Service> root = cq.from(Service.class);
        cq.where(cb.equal(root.join(Service_.subscribers).get(Subscriber_.id), idSubscriber)).distinct(true);
        List<Service> services = manager.createQuery(cq).getResultList();
        return services;
    }
}
