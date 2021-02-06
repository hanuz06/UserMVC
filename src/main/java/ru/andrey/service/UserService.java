package ru.andrey.service;

import ru.andrey.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws Exception;
    void deleteUser(Long id);
    void updateUser(User user);
    List<User> listUsers();
    User getUser(Long id);
}
