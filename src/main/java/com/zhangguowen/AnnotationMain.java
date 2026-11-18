package com.zhangguowen;

import com.zhangguowen.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ch2.5.2 基于注解的装配 + 真连 SQL Server
 */
public class AnnotationMain {
    public static void main(String[] args) {
        // 先传配置类，再手动扫包
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DataConfig.class);       // 注册数据库配置类
        context.scan("com.zhangguowen");          // 扫业务包（@Repository/@Service）
        context.refresh();                        // 刷新容器，让配置生效

        UserService userService = context.getBean("userService", UserService.class);

        System.out.println("========== 开始测试 ==========");
        System.out.println();

        // 测试 1：真存一个用户进 SQL Server
        System.out.println("【测试 1】存用户 zhaoliu / 888888");
        userService.saveUser("zhaoliu", "888888");
        System.out.println();

        // 测试 2：从 SQL Server 查所有用户
        System.out.println("【测试 2】查 SQL Server 里所有用户");
        userService.findAllUsers();
        System.out.println();

        System.out.println("========== 测试完成 ==========");
        context.close();
    }
}
