package com.example.user_manager.dao;

import com.example.user_manager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public void insertUser(User user) throws SQLException;
    public boolean updateUser(User user)throws SQLException;
    public boolean deleteUser(int id)throws SQLException;
    public User selectUser(int id);
    public List<User>selectAllUser();
    public List<User>selectAllUser(String country);
}
