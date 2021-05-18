package by.katsuba.lab5.dao.impl;

import by.katsuba.lab5.dao.SubscriberDao;
import by.katsuba.lab5.entity.Subscriber;
import by.katsuba.lab5.entity.Subscriber_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Class SubscriberDao for getting data about subscribers from db
 *
 * @author Nastassia Katsuba
 * @version 1.0
 */
@Stateless
public class SubscriberDaoImpl implements SubscriberDao {
    private EntityManager manager;

    public SubscriberDaoImpl() {
        manager = Persistence.createEntityManagerFactory("station").createEntityManager();
    }

    /**
     * Reading all subscribers
     *
     * @return list of subscribers
     */
    @Override
    public List<Subscriber> readSubscribers() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Subscriber> cq = cb.createQuery(Subscriber.class);
        Root<Subscriber> root = cq.from(Subscriber.class);
        cq.select(root);
        List<Subscriber> subscribers = manager.createQuery(cq).getResultList();
        return subscribers;
    }

    /**
     * Reading subscriber by id
     *
     * @param id - subscriber's id
     * @return subscriber
     */
    @Override
    public Subscriber readSubscriberById(long id) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Subscriber> cq = cb.createQuery(Subscriber.class);
        Root<Subscriber> root = cq.from(Subscriber.class);
        cq.where(cb.equal(root.get(Subscriber_.id), id));
        Subscriber subscriber = (Subscriber) manager.createQuery(cq).getResultList().get(0);
        return subscriber;
    }

    /**
     * Inserting new subscriber
     *
     * @param subscriber - subscriber
     * @return true if insert successfully, false if otherwise
     */
    @Override
    public boolean insertSubscriber(Subscriber subscriber) {
        boolean check = true;
        manager.persist(subscriber);
        return check;
    }

    /**
     * Deleting subscriber
     *
     * @param subscriber - subscriber
     * @return true if delete successfully, false if otherwise
     */
    @Override
    public boolean deleteSubscriber(Subscriber subscriber) {
        boolean check = true;
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaDelete<Subscriber> cd = cb.createCriteriaDelete(Subscriber.class);
        Root<Subscriber> root = cd.from(Subscriber.class);
        cd.where(cb.equal(root.get(Subscriber_.id), subscriber.getId()));
        manager.createQuery(cd).executeUpdate();
        return check;
    }


    /**
     * Reading subscriber's sum
     *
     * @param subscriber - subscriber
     * @return subscribers with sum
     */
    @Override
    public float readSubscribersSum(Subscriber subscriber) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Subscriber> cq = cb.createQuery(Subscriber.class);
        Root<Subscriber> root = cq.from(Subscriber.class);
        cq.where(cb.equal(root.get(Subscriber_.id), subscriber.getId()));
        float sum = manager.createQuery(cq).getSingleResult().getSum();
        return sum;
    }

    /**
     * Paying subscriber's bill by his id and blocking him
     *
     * @param idSubscriber - subscriber's
     * @return true if bill's payed and subscriber's blocked
     */
    @Override
    public boolean payBillAndBlock(long idSubscriber) {
        boolean check = true;
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        manager.joinTransaction();
        CriteriaUpdate<Subscriber> cu = cb.createCriteriaUpdate(Subscriber.class);
        Root<Subscriber> root = cu.from(Subscriber.class);
        cu.set(root.get(Subscriber_.sum), 0f);
        cu.set(root.get(Subscriber_.status), false);
        cu.where(cb.equal(root.get(Subscriber_.id), idSubscriber));
        manager.createQuery(cu).executeUpdate();
        return check;
    }
}
