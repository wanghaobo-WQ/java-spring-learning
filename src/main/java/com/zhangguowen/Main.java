package com.zhangguowen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("====== 静态工厂实例化 (ch2.4.2) ======");
        User user = context.getBean("user", User.class);
        user.sayHello();

        System.out.println();
        System.out.println("====== 实例工厂实例化 (ch2.4.3) ======");
        User user2 = context.getBean("user2", User.class);
        user2.sayHello();
    }
}