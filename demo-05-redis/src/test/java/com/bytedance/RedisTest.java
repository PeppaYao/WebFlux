package com.bytedance;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //opsForValue() 操作字符串
        //opsForList() 操作列表
        //opsForSet()
        redisTemplate.opsForValue().set("myKey4","YaoJun");
        System.out.println(redisTemplate.opsForValue().get("myKey4"));
    }

}

