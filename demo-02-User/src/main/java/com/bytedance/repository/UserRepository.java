package com.bytedance.repository;


import com.bytedance.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    //采用内存型的存储方式
    private final ConcurrentMap<Integer, User> repository
            = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator
            =  new AtomicInteger();

    //保存用户对象，如果保存成功返回True
    public boolean save(User user){
        //id从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        //put方法有返回值 如果返回null就说明放入成功
        return repository.put(id, user)==null;

    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
