# Fsocity 
Fsocity是一款Spring Boot极速开发的脚手架。其中集成代码生成、MySQL、Redis、Spring Security、
Admin快速开发等功能。

## 技术架构
| 技术选型                | 版本    | 说明             |
| ---------------------- | ------- | ---------------- |
| Spring Boot            | 2.5.9   | 容器+MVC框架     |
| Spring Security        | 5.5.4   | 认证和授权框架   |
| MyBatis                | 3.5.9   | ORM框架          |
| MyBatis-Plus           | 3.5.1   | MyBatis增强工具  |
| MyBatis-Plus Generator | 3.5.1   | 数据层代码生成器 |
| Swagger-UI             | 3.0.0   | 文档生产工具     |
| Redis                  | 5.0     | 分布式缓存       |
| Druid                  | 1.1.22  | 数据库连接池     |
| JWT                    | 0.9.0   | JWT登录支持      |
| Lombok                 | 1.18.22 | 简化对象封装工具 |

## 如何使用？

### 环境搭建
JDK1.8+，并且只需安装最常用的**MySql**和**Redis**服务即可。

### 开发规约
```text
src
├── framework
|   ├── exception              -- 错误处理类
|   ├── mybatis                -- mybatis配置和使用
|   ├── redis                  -- redis配置和使用
|   ├── security               -- security配置和使用
|   ├── swagger                -- swagger配置和使用
|   ├── util                   -- 封装工具类
|   ├── web                    -- web开发常用类
|   ├── MyBatisPlusGenerator   -- 代码生成器
├── modules                    -- 模块文件夹
|   ├── admin                  -- admin模块
├── resources                  -- 资源目录
|   ├── mapper                 -- mybatis mapper xml文件目录
|   ├── static                 -- 静态资源文件目录
|   ├── templates              -- 模版目录
|   |   ├── thymeleaf          -- thymeleaf模版目录
|   |   ├── vm                 -- vm模版目录（主要用于代码生成）
|   ├── application.yml        -- Spring Boot配置文件
|   ├── application-dev.yml    -- 开发配置文件
|   ├── application-prod.yml   -- 生产配置文件
|   ├── logback-spring.xml     -- 日志配置文件
|   ├── logback-spring-dev.xml -- 本地日志配置文件
```

### 项目运行
直接运行启动类`FsocityApplication`的`main`函数即可。

### 使用代码生成器
> 运行MyBatisPlusGenerator类的main方法来生成代码，可直接生成controller、service、mapper、entity、mapper.xml
的代码，无需手动创建。


