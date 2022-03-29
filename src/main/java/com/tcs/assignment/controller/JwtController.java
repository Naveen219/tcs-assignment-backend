package com.tcs.assignment.controller;

import com.tcs.assignment.helper.JwtUtil;
import com.tcs.assignment.model.JwtResponse;
import com.tcs.assignment.model.User;
import com.tcs.assignment.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody User theUser) throws Exception{

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(theUser.getUserName(), theUser.getPassword()));

        }
        catch(UsernameNotFoundException ex)
        {
            ex.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        catch(BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(theUser.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT: " + token);

        return ResponseEntity.ok(new JwtResponse(token));

    }

}
