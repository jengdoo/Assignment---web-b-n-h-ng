package com.fpoly.assignmentjava6.service;

import com.fpoly.assignmentjava6.model.User;

public interface UserService {
    User findByUserName(String name);
}
