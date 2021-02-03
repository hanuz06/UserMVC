package ru.andrey.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrey.dao.UserDao;
import ru.andrey.dao.UserDaoImpl;
import ru.andrey.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDaoImpl;

    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDaoImpl.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDaoImpl.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDaoImpl.updateUser(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDaoImpl.listUsers();
    }

    @Transactional
    @Override
    public User getUser(Long id) {
        return userDaoImpl.getUser(id);
    }
}
