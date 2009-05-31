spring对AOP的只是（采用Annotation的方式）

1、spring依赖库
	* SPRING_HOME/dist/spring.jar
	* SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	* SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	* SPRING_HOME/lib/aspectj/*.jar
	
2、采用Aspect定义切面

2、在Aspect定义Pointcut和Advice

4、启用AspectJ对Annotation的支持并且将Aspect类和目标对象配置到Ioc容器中

注意：在这种方法定义中，切入点的方法是不被执行的，它存在的目的仅仅是为了重用切入点
即Advice中通过方法名引用这个切人点

AOP:
	* Cross cutting concern
	* Aspect
	* Advice
	* Pointcut
	* Joinpoint
	* Weave
	* Target Object
	* Proxy
	* Introduction