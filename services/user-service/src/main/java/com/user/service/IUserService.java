package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface IUserService {
    public void createUser(User user);
    public List<User> getUser();
    public User findById(long id);
    public User update(User user);
    public void deleteUserById(long id);
}