# Spring Boot App Stater 使用说明

## 接入前准备

1、由于涉及到数据库的相关操作，请先检查创建相应的数据库和表

```mysql
CREATE TABLE `user` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(33) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `money` double DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
```

数据库连接信息在`resouces`目录下的`application.properties`文件中配置

```properties
spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/demo_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai
spring.datasource.username = root
spring.datasource.password = root
```

## 框架介绍

1、该框架基于`spring boot 2.1.8.RELEASE` 框架编写，用于作为Spring Boot开发脚手架

2、同时包含了`Hibernate`、`Mybatis`两种`ORM`框架，用户可自行选择使用

3、日志系统替换为性能更优异的`log4j2`，具体配置可以修改`resources`目录下的`log4j2.xml`文件

4、集成了`swagger`作为API文档的自动生成工具，并且整合了`swagger-ui`提供可视化界面
