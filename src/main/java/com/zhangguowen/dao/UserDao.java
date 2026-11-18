package com.zhangguowen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//把这个类注册成 Spring Bean
@Repository
public class UserDao {

    // Spring 自动把 JdbcTemplate 注入进来（DataConfig 里建的那个 Bean）
    @Autowired
    private JdbcTemplate jdbc;

    /**
     * 存用户到 SQL Server
     * SQL Server 用 GETDATE() 代替 MySQL 的 NOW()
     */
    public int saveUser(String name, String pwd) {
        int rows = jdbc.update(
            "INSERT INTO users(name, pwd) VALUES(?, ?)",
            name, pwd
        );
        System.out.println("  [DAO层] 执行 INSERT INTO users(name, pwd) VALUES('" + name + "', '" + pwd + "') → 影响 " + rows + " 行");
        return rows;
    }

    /**
     * 从 SQL Server 查所有用户
     */
    public List<Map<String, Object>> findAll() {
        List<Map<String, Object>> list = jdbc.queryForList("SELECT * FROM users");
        System.out.println("  [DAO层] 执行 SELECT * FROM users → 查到 " + list.size() + " 条");
        return list;
    }
}
