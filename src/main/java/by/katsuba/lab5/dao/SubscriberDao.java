package by.katsuba.lab5.dao;

import by.katsuba.lab5.entity.Subscriber;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SubscriberDao {
    List<Subscriber> readSubscribers();

    Subscriber readSubscriberById(long id);

    boolean insertSubscriber(Subscriber subscriber);

    boolean deleteSubscriber(Subscriber subscriber);

    float readSubscribersSum(Subscriber subscriber);

    boolean payBillAndBlock(long idSubscriber);
}
