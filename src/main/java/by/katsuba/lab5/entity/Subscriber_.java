package by.katsuba.lab5.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Subscriber.class)
public class Subscriber_ {
    public static volatile SingularAttribute<Subscriber, Long> id;
    public static volatile SingularAttribute<Subscriber, String> name;
    public static volatile SingularAttribute<Subscriber, Boolean> status;
    public static volatile SingularAttribute<Subscriber, Float> sum;
    public static volatile ListAttribute<Subscriber, Service> services;
}
