1、spring依赖库
	* SPRING_HOME/dist/spring.jar
	* SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	* SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	
2、拷贝spring配置文件到src下

3、拷贝log4j配置文件到src下

4、在UserManagerImpl中提供构造函数或setter方法，spring将实例化好的UserDao实现注入给我们

5、让spring管理我们的对象创建和依赖，必须在spring配置中进行定义

6、编写客户端


spring Ioc容器的关键点：
	* 必须将被管理的对象定义到spring配置文件中
	* 必须定义构造函数或setter方法，让spring将对象注入过来
	