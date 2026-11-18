package com.zhangguowen;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ch3 AOP 配置类
 * @EnableAspectJAutoProxy: 开启注解版 AOP（代替 XML 的 <aop:aspectj-autoproxy/>）
 * proxyTargetClass = true: 用 CGLIB 生成子类代理
 *                          （UserDao 没有实现接口，默认的 JDK 动态代理做不了，必须用 CGLIB）
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
