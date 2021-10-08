package com.example.mapper;

import com.example.dto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAll();

    Integer insertOne(User user);

    Integer deleteById(@Param("id") Integer id);

    void updatePassword(User user);

    void insertBatch(@Param("users") List<User> users);
}
