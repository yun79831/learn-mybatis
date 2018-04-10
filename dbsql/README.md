课程源码：
1. 编程式项目 http://git.gupaoedu.com/vip/gupaoedu-mybatis
 
2. 集成spring
http://git.gupaoedu.com/vip/gupao-springmvc
 
注意查看项目下的分支，上课用的是vip分支
 
git、maven、idea学习教程 http://bbs.gupaoedu.com/forum.php?mod=viewthread&tid=380&extra=page%3D1&_dsign=4b78d4bb

* 20180324
1. Mapper在spring管理下其实是单例，为什么可以是一个
单例？ SCOPE -> application
 
2. MyBatis在Spring集成下没有mapper的xml文件会不会
报错，为什么？
 
3. TypeHandler手写
 
4. 手写Plugin,多个interceptor到底谁先执行？顺序由谁
决定的？

* 20180325
1.怎么验证一级缓存的存在？
2.验证N+1问题

* 20180328
1. org.apache.ibatis.binding.MapperProxy#invoke 这个类的53行什么时候执行？

* 20180331
1. TestMapper 作者为什么要设计这样的形式来做？
为什么不是一个class而是一个interface?
 
2.org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义
 
3.MyBatis的plugin实现机制
 
4.lazy loading 是怎么做到的？
 
部分笔记
 
createResultObject
 
1.族群隔离 
2.分类选择大类处理
3.日志、共性动作很好的分离
 
 
同源下的delegate -->装饰器
 
controller
service 
    rpc
    rpc
    rpc
     
     
1.0版本
 
TestMapper --- > TestMapper.xml
找到SQL



* 20180401
1. 手写1.0
2. 2.0版本的基础上，用annotation
 
 
部分笔记
为什么javaconfig 比xml用得多了
 
1. Executor主要的功能是query
2. query里分解动作
    -》执行拿到结果  StatementHandler  17-24
    -》结果映射      ResultSetHandler  25

20180408
1.  2.0版本加入plugin功能