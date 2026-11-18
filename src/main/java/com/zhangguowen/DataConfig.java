package com.zhangguowen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// @Configuration: 这是一个 Spring 配置类（代替 XML 里的 <bean> 声明）
@Configuration
// @PropertySource: 读 src/main/resources/jdbc.properties 这个配置文件
@PropertySource("classpath:jdbc.properties")
public class DataConfig {

    // @Value: 从 properties 文件里取值，塞到字段里
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // @Bean: 把这个方法返回的对象注册成 Spring Bean
    // DataSource = 数据库连接池（帮你管理连接、开关、复用）
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    // JdbcTemplate = Spring 帮你执行 SQL 的工具（自动开关连接、自动转对象）
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
