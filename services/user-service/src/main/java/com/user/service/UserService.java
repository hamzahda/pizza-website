package com.example.service;

import java.util.List;

import com.example.entity.User;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(final User user) {
        userRepository.save(user);
    }

    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    public User findById(final long id) {
        return userRepository.findById(id).orElseThrow(() -> 
        new RuntimeException("user is not found"));
    }

    public User update(final User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(final long id) {
        userRepository.deleteById(id);
    }

}