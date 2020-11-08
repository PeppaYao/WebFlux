package com.bytedance.mapper;

import com.bytedance.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
//表示这是一个mybatis的mapper类
public interface UserMapper {
    List<User> queryUserList();
    boolean addUser(User user);
}
