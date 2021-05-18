package by.katsuba.lab5.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;

@StaticMetamodel(User.class)
public class User_ implements Serializable {
    public static volatile SingularAttribute<User, String > login;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> type;
}
