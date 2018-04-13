# Mybatis源码学习笔记
## 认识mybatis 
   [Mybatis官网](http://www.mybatis.org/mybatis-3/zh/index.html)
   MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。
## 学习Mybatis

### 使用方式
1. 编程式(JAVA API方式)
2. 集成式(基于XML方式)
3. mybatis创建sqlsession经过了以下几个主要步骤：
    1. 从核心配置文件mybatis-config.xml中获取Environment（这里面是数据源）；
    
    2. 从Environment中取得DataSource；
    
    3. 从Environment中取得TransactionFactory；
    
    4. 从DataSource里获取数据库连接对象Connection；
    
    5. 在取得的数据库连接上创建事务对象Transaction；
    
    6. 创建Executor对象（该对象非常重要，事实上sqlsession的所有操作都是通过它完成的）；
    
    7. 创建sqlsession对象。

### sql配置方式
1. XML配置
2. 注解配置

### 开发顺序
1. 分析业务
2. 定义表
3. generator生成所需要的类

### 作用域scope
1. SqlSessionFactoryBuilder
2. SqlSessionFactory-->session
3. SqlSession -->method
4. Mapper -->method

### 配置  
1. configuration各元素
    1. environment
    2. type handle
    3. plugin

2. mapper.xml

## 手写框架
1. V1.0
2. V2.0

## mybatis-spring集成原理