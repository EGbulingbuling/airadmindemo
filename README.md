# airadmindemo

## 项目介绍
    基于Spring+SpringMVC+Mybatis的机票订购平台，实现了登录退出、修改密码、查询机票、购买机票、撤销购买等功能。
    这个项目实现比较简单，比较适合新手熟悉项目，有很多的不足希望大家指正，欢迎大家star(*^▽^*)

### 技术选型

#### 后端技术:
技术 | 名称 | 官网
----|------|----
Spring Framework | 容器  | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)
SpringMVC | MVC框架  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)
Apache Shiro | 安全框架  | [http://shiro.apache.org/](http://shiro.apache.org/)
MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
Druid | 数据库连接池  | [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
Thymeleaf | 模板引擎  | [http://www.thymeleaf.org/](http://www.thymeleaf.org/)
Maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)
Logback | 日志组件  | [http://logging.apache.org/log4j/1.2/](http://logback.qos.ch/)
Redis | 分布式缓存数据库  | [https://redis.io/](https://redis.io/)

#### 前端技术:
技术 | 名称 | 官网
----|------|----
jQuery | 函式库  | [http://jquery.com/](http://jquery.com/)

前端模板是我从网上找的，如果涉及版权问题请QQ联系我 2051190945

### 框架规范约定

约定优于配置(convention over configuration)，此框架约定了很多编程规范，下面一一列举：

```

- service类，需要在叫名`service`的包下，并以`Service`结尾，如`CmsArticleServiceImpl`
- mapper.xml，需要在名叫`mapper`的包下，并以`Mapper.xml`结尾，如`CmsArticleMapper.xml`
- mapper接口，需要在名叫`mapper`的包下，并以`Mapper`结尾，如`CmsArticleMapper.java`
- pojo实体类，需要在名叫`pojo`的包下，命名规则为数据表转驼峰规则，如`CmsArticle.java`
- 类名：首字母大写驼峰规则；方法名：首字母小写驼峰规则；常量：全大写；变量：首字母小写驼峰规则，尽量非缩写
- 配置文件放到`src/main/resources`目录下
- 静态资源文件放到`src/main/resources/templates`目录下
- `RequestMapping`和返回物理试图路径的url尽量写全路径，如：`@RequestMapping("/manage")`、`return "/manage/index"`
- 数据表命名为：`子系统`_`表`，如`cms_article`

- 更多规范，参考[[阿里巴巴Java开发手册] http://git.oschina.net/shuzheng/zheng/attach_files

```

## 演示地址

演示地址： [http://localhost:8080/login]

### 预览图
![login](https://raw.githubusercontent.com/EGbulingbuling/airadmindemo/master/demo_pictures/login.png)

### 数据模型

### 开发进度


## 许可证

[MIT](LICENSE "MIT")
