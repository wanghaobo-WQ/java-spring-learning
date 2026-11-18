package com.zhangguowen.service;

import com.zhangguowen.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service: 把这个类注册成 Spring Bean
@Service
public class UserService {

    // @Autowired: Spring 自动把 UserDao 注入进来
    @Autowired
    private UserDao userDao;

    /**
     * 业务层：调 DAO 存用户
     * 注意：Service 只管「调 DAO」，不知道 DAO 里面是 SQL Server、MySQL 还是文件
     */
    public void saveUser(String name, String pwd) {
        System.out.println("[Service层] 收到业务请求：存用户 " + name);
        userDao.saveUser(name, pwd);
        System.out.println("[Service层] 业务完成");
    }

    public void findAllUsers() {
        System.out.println("[Service层] 收到业务请求：查所有用户");
        userDao.findAll();
    }
}
