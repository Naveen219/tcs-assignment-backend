package com.tcs.assignment.controller;

import com.tcs.assignment.model.User;
import com.tcs.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User theUser) {
        Optional<User> userOptional =  userService.getUserByName(theUser.getUserName().trim());
        User tempUser = null;
        if (userOptional.isPresent()) {
            tempUser = userOptional.get();
            if (tempUser.getPassword().equals(theUser.getPassword())) {
                return ResponseEntity.ok(tempUser);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
