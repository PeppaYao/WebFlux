package com.bytedance;

import com.bytedance.domain.User;
import com.bytedance.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class JpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User(4, "jj",189));
        userRepository.save(new User(5, "kk",189));
        List<User> all = userRepository.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
