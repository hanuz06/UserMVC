package ru.andrey.dao;

import ru.andrey.models.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws IOException, Exception;
    void deleteUser(Long id);
    void updateUser(User user);
    List<User> listUsers();
    User getUser(Long id);
}
