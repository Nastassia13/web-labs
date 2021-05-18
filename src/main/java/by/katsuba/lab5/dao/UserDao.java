package by.katsuba.lab5.dao;

import by.katsuba.lab5.entity.User;

import javax.ejb.Remote;

@Remote
public interface UserDao {
    User readUser(String login, String password);

    boolean readUserByLogin(String login);

    void insertUser(User user);
}
