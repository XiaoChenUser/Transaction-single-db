package com.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

//@Data
//@Accessors(chain = true)
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createAt;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public User setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }
}
