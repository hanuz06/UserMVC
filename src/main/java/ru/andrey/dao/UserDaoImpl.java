package ru.andrey.dao;

import org.springframework.stereotype.Repository;
import ru.andrey.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User userToBeDeleted = getUser(id);
        if (userToBeDeleted!=null){
            entityManager.remove(userToBeDeleted);
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("SELECT e FROM User e");
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
       return entityManager.find(User.class, id);
    }
}
