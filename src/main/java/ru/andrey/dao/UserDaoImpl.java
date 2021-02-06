package ru.andrey.dao;

import org.springframework.stereotype.Repository;
import ru.andrey.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.*;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());


    @Override
    public void addUser(User user) throws Exception {
        Handler fileHandler = new FileHandler();
        LOGGER.addHandler(fileHandler);
        LOGGER.setUseParentHandlers(false);
        entityManager.persist(user);
        LOGGER.info("User has been added");
    }

    @Override
    public void deleteUser(Long id) {
        User userToBeDeleted = getUser(id);
        if (userToBeDeleted!=null){
            entityManager.remove(userToBeDeleted);
            LOGGER.info("User has been deleted");
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        LOGGER.info("User has been updated");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("SELECT e FROM User e");
        LOGGER.info("User list has been returned");
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        LOGGER.info("User has been found and returned");
       return entityManager.find(User.class, id);
    }
}
