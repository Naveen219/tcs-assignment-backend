package com.tcs.assignment.service;

import com.tcs.assignment.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByName(String userName);
}
