package com.tcs.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.tcs.assignment.model.User> userOptional =  userService.getUserByName(userName.trim());
        if (userOptional.isPresent() && userOptional.get().getUserName().equals(userName)) {
                return new User(userOptional.get().getUserName(),userOptional.get().getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
