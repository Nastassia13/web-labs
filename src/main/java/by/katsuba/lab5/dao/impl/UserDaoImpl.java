package by.katsuba.lab5.dao.impl;

import by.katsuba.lab5.dao.UserDao;
import by.katsuba.lab5.entity.User;
import by.katsuba.lab5.entity.User_;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UserDaoImpl implements UserDao {
    private EntityManager manager;

    public UserDaoImpl() {
        manager = Persistence.createEntityManagerFactory("station").createEntityManager();
    }

    @Override
    public User readUser(String login, String password) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.where(cb.and(cb.equal(root.get(User_.login), login), cb.equal(root.get(User_.password), password)));
        User user = manager.createQuery(cq).getSingleResult();
        return user;
    }

    @Override
    public boolean readUserByLogin(String login) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.where(cb.equal(root.get(User_.login), login));
        return manager.createQuery(cq).getResultList().stream().findAny().isPresent();
    }

    @Override
    public void insertUser(User user) {
        manager.joinTransaction();
        manager.persist(user);
    }
}
