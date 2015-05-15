package com.vspavlov.demoorm.service;

import com.vspavlov.demoorm.domain.User;
import com.vspavlov.demoorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vasiliy on 08.05.2015.
 */
@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }





}
