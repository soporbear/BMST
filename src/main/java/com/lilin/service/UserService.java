package com.lilin.service;

import com.lilin.dao.UserDao;
import com.lilin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> userList() {
        return userDao.selectAllUser();
    }

    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }

    public void delete(int id){
        userDao.deleteUserById(id);
    }

    public void insert(String userName, String password){
        userDao.insertUser(userName, password);
    }

    public void update(int id, String userName, String password){
        userDao.updateUser(id, userName, password);
    }

    public User userCheck(String userName, String password) {
        return userDao.checkUser(userName, password);
    }
}
