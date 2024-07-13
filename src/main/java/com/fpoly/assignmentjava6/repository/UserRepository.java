package com.fpoly.assignmentjava6.repository;

import com.fpoly.assignmentjava6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String userName);
}
