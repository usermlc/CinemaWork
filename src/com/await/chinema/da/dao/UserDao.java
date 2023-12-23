package com.await.chinema.da.dao;

import com.await.chinema.bl.Json;
import com.await.chinema.da.entity.User;

import java.util.List;
import java.util.Optional;
public class UserDao implements Dao<User> {

    private List<User> userList;

    public UserDao(){
        userList = Json.jsonUserList();
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
