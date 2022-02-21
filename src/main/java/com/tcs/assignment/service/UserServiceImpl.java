package com.tcs.assignment.service;

import com.tcs.assignment.model.User;
import com.tcs.assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public Optional<User> getUserByName(String userName) {
        return  userRepo.findByUserName(userName);
    }
}
