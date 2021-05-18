package by.katsuba.lab5.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Service.class)
public class Service_ {
    public static volatile SingularAttribute<Service, Long> id;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, Float> cost;
    public static volatile ListAttribute<Service, Subscriber> subscribers;
}
