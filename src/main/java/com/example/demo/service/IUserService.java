package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;

import java.util.List;

public interface IUserService {

    public User addUser(UserRequest request) throws Exception;

    void removeUser(Long id);

    List<User> getUsers();
}
