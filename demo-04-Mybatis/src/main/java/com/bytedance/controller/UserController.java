package com.bytedance.controller;

import com.bytedance.mapper.UserMapper;
import com.bytedance.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private final static AtomicInteger idGenerator = new AtomicInteger();

    @PostMapping("/add/user")
    public boolean addUser(@RequestParam("username") String name, @RequestParam("pwd") int pwd){
        User user = new User() ;
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        user.setPwd(pwd);
        user.setName(name);
        return userMapper.addUser(user);
    }
}
