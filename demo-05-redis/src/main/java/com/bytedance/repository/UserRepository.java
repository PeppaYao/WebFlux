package com.bytedance.repository;

import com.bytedance.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
    User findAllById(String userName);
}
