package com.bytedance.controller;


import com.bytedance.domain.User;
import com.bytedance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//返回json对象
@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        boolean status = userRepository.save(user);
        if(status == true){
            System.out.println("成功创建用户, "+user.getName()+" "+user.getId());
        }
        return user;
    }
}
