package com.example;

import com.alibaba.fastjson.JSON;
import com.example.dto.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.service.UserService2;
import com.example.utils.StrUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class TransactionDemoApplicationTests {
//    @Autowired
//    @Qualifier("localDataSource")
//    private DataSource localDataSource;
//
//    @Autowired
//    @Qualifier("remoteDataSource")
//    private DataSource remoteDataSource;


    @Autowired
    private UserService userService;
    @Autowired
    private UserService2 userService2;
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void getAllTest(){
        List<User> users = userService.getAll();
        users.forEach(user -> System.out.println(JSON.toJSONString(user)));
    }

    @Test
    void insertOneTest(){
        User user = new User().setUsername(UUID.randomUUID().toString()).setPassword("abc123");
        userMapper.insertOne(user);
    }

    @Test
    void updatePasswordTest(){
        User user = new User().setId(114).setPassword("abcd1234");
        userMapper.updatePassword(user);
    }

    @Test
    void insertBatchTest(){
        List<User> users = new ArrayList<>();
        User user = null;
        Date now = new Date();
        for (int i = 0; i < 30; i++) {
            user = new User().setUsername(UUID.randomUUID().toString()).setPassword("abc123").setCreateAt(now);
            users.add(user);
        }

        userMapper.insertBatch(users);
    }

    //------------------ Transaction test beginning ----------------------------
    @Test
    void insertTest(){
        List<User> users = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 30; i++) {
            user = new User().setUsername(UUID.randomUUID().toString()).setPassword("abc123");
            users.add(user);
        }
        userService.insertAll(users);
    }

    @Test
    void insertProxyTest() {
        User user = new User().setUsername("Xiao Hong").setPassword("abc123");
        User user2 = new User().setUsername("Xiao Peng").setPassword("abc123");
        userService.insertProxy(Arrays.asList(user, user2));
    }

    @Test
    void deleteById(){
        userService.deleteById(1);
    }

    @Test
    void privateProxyTest(){
        userService.innerCallPrivateDel(1);
    }

    @Test
    void selfCallTest(){
        userService.innerCallDel(2);
    }

    @Test
    void userService2Test(){
        userService2.deleteById(9);
    }

    @Test
    void getMethod(){
        StrUtils.getMethodList(UserService.class);
    }

}
