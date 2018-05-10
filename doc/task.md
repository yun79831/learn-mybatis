# Mybatis课后作业
课程源码：
1. 编程式项目 http://git.gupaoedu.com/vip/gupaoedu-mybatis
2. 集成spring
http://git.gupaoedu.com/vip/gupao-springmvc
注意查看项目下的分支，上课用的是vip分支
git、maven、idea学习教程 http://bbs.gupaoedu.com/forum.php?mod=viewthread&tid=380&extra=page%3D1&_dsign=4b78d4bb

## 20180324

1. Mapper在spring管理下其实是单例，为什么可以是一个
单例？ SCOPE -> application
 
2. MyBatis在Spring集成下没有mapper的xml文件会不会
报错，为什么？
spring中有异常处理,不会报错,还支持注解模式
 
3. TypeHandler手写
 com.learn.mybatis.typehandler.StringTypeHandler
 
4. 手写Plugin,多个interceptor到底谁先执行？顺序由谁
决定的？
倒序执行

## 20180325
1.怎么验证一级缓存的存在？
2.验证N+1问题

## 20180328
1. org.apache.ibatis.binding.MapperProxy#invoke 这个类的53行什么时候执行？

## 20180331
1. TestMapper 作者为什么要设计这样的形式来做？
为什么不是一个class而是一个interface?
 
2. org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义
 
3. MyBatis的plugin实现机制
 
4. lazy loading 是怎么做到的？

## 20180401
1. 手写1.0
2. 2.0版本的基础上，用annotation
 
 
    部分笔记
    为什么javaconfig 比xml用得多了
    1.Executor主要的功能是query
    2.query里分解动作
        -》执行拿到结果  StatementHandler  17-24
        -》结果映射      ResultSetHandler  25

## 20180408
1.  2.0版本加入plugin功能





1.Mapper在spring管理下其实是单例，为什么可以是一个 单例？ SCOPE -> application

mapper在mybatis里是一个Method级别的,当一次sqlSession结束之后,也就关闭了;在Spring管理下,变成了一个单列,让它一直存在,可以在该mapper的所有sqlSession使用,变成了一个application级别的

2.MyBatis在Spring集成下没有mapper的xml文件会不会报错,为什么？ 不会,可以用注解的方式annotation

3.TypeHandler手写 4.手写Plugin,多个interceptor到底谁先执行？顺序由谁 决定的？

后注册的先执行,然后通过for循环遍历一一取出来,与MapperProxy代理有关，倒序

5.怎么验证一级缓存的存在？

对于某个查询,去缓存Cache中取出对应的的缓存结果,如果命中,取出结果值,没有就去查询数据库,可以在给某个查询设置查询时间,观察时间进行对比

6.验证N+1问题

2表关联学生表与班级表,进行嵌套查询,开启懒加载,当只需要查询班级信息,就取班级信息,就是1,当取学生信息时就是N,一个班级对应多个学生,减轻数据库的压力



1、TestMapper 作者为什么要设计这样的形式来做？为什么不是一个class而是一个interface?
使用接口映射的方式，最主要的是为了尽量的简化编码操作，将更多的事情交给mapper.xml来实现，而接口中只需要声明methodName与mapper.xml映射就可以了，清晰明了方便维护

2、org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义
应该在关联查询，开启懒加载时候再能起到真正的作用，主要用于当前的关联查询先占位不执行，当真正调用关联查询中的数据时，判断当前的缓存中是否已缓存查询数据并且是否已经占位，如果存在数据并且没有占位则直接从缓存中获取数据，如果已经占位或者没有缓存，则直接进行数据的查询。

3、MyBatis的plugin实现机制
plugin通过责任链和代理的方式去实现的，具体的，首先通过configuration创建时，读取配置文件将配置中的plugin载入interceptorChain中，在configuration创建Executor时，执行interceptorChain.pluginAll，所有的连接器都对executor进行了一次代理，最终当执行executor是则将所有的plugin都执行一次。

4、lazy loading 是怎么做到的？
启动懒加载后，mybatis初始化返回类型的时候，会返回一个cglib的代理对象，cglib会过滤get，set等方法，，当调用这些方法cglib则会去执行相应的查询语句，进行第二次关联信息对应的表查询语句，查询结束后将值赋值给对象

