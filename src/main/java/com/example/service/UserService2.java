package com.example.service;

import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service("userService2")
public class UserService2 extends UserService{

    private UserMapper userMapper;

    public UserService2(UserMapper userMapper) {
        super(userMapper);
        this.userMapper = userMapper;
    }

//    @Override
//    public void deleteById(Integer id) {
//        userMapper.deleteById(id);
//        throw new RuntimeException("test2");
//    }
}
