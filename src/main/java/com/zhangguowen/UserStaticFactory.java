package com.zhangguowen;

public class UserStaticFactory {
    // 静态方法，返回 User 实例 —— Spring 会调这个 static 方法而不是 new User()
    public static User createUser() {
        System.out.println("静态工厂被调用：UserStaticFactory.createUser()");
        return new User();
    }
}
