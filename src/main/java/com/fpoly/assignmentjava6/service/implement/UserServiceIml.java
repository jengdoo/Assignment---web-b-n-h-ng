package com.fpoly.assignmentjava6.service.implement;

import com.fpoly.assignmentjava6.model.User;
import com.fpoly.assignmentjava6.repository.UserRepository;
import com.fpoly.assignmentjava6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }
}
