package com.zhangguowen;

// 实例工厂：方法不是 static，必须先 new 出这个工厂对象才能调
public class UserInstanceFactory {
    public User createUser() {
        System.out.println("实例工厂被调用：先 new UserInstanceFactory，再调 createUser()");
        return new User();
    }
}
