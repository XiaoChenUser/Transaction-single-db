package com.example.service;

import com.example.dto.User;
import com.example.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserService self(){
        return (UserService)AopContext.currentProxy();
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }

    @Transactional
    public void insertAll(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            userMapper.insertOne(users.get(i));
            int a = 5 / 0;
        }
    }

    @Transactional
    public void insertProxy(List<User> users) {
        insertAll(users);
    }

    @Transactional
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
        throw new RuntimeException("test");
    }

    @Transactional
    private void deleteWithTransaction(Integer id) {
        userMapper.deleteById(id);
        throw new RuntimeException("test");
    }

    public void innerCallPrivateDel(Integer id) {
        deleteWithTransaction(id);
    }


    public void innerCallDel(Integer id) {
//        self().deleteById(id);
        deleteById(id);
    }
}
