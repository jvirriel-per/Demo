package com.jvirriel.demo.backend.users;


import com.jvirriel.demo.model.users.User;

import java.util.List;


public interface UserService {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);

}
