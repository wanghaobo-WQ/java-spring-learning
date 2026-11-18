# java-spring-learning

学习 Spring 框架过程中的练习代码（黑马 Spring 教程 ch2 / ch3）。

## 技术栈

- Java 8 / Maven
- Spring 5.3.20（IoC、AOP）
- Spring JDBC + JdbcTemplate
- H2 内存数据库
- AspectJ（注解版 AOP）

## 项目内容

| 文件 | 说明 |
|---|---|
| `AnnotationMain.java` | 注解版启动入口：扫描包 → 调用 Service → 执行 SQL |
| `Main.java` | XML 版启动入口：静态工厂 / 实例工厂练习 |
| `service/UserService.java` | 业务层，通过 `@Autowired` 调用 DAO |
| `dao/UserDao.java` | 数据层，用 `JdbcTemplate` 执行 INSERT / SELECT |
| `aop/AnnoAdvice.java` | 切面类：前置、返回、异常、后置、环绕 5 种通知 |
| `AopConfig.java` | 开启注解版 AOP（`@EnableAspectJAutoProxy`） |

## 怎么运行

1. 用 IntelliJ IDEA 打开本项目根目录（`pom.xml` 所在目录）
2. 等待 Maven 依赖下载完成
3. 运行 `com.zhangguowen.AnnotationMain` 的 `main` 方法

控制台会输出 Service 层、DAO 层以及 AOP 通知的打印日志。
