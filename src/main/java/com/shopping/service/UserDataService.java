package com.shopping.service;

import com.shopping.entities.User;
import com.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    UserRepository userRepository;

    public User getUserDetails(String username){
        return userRepository.findByUsername(username);
    }
}
