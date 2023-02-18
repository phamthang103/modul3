package com.example.user_manager.dao;

import com.example.user_manager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public List<User>findAll();
    public void addUser(User user) throws SQLException;
    public User findById(int id);
    public boolean deleteUser(int id) throws SQLException;
    public boolean editUser(User user)throws SQLException;


}
