spring对AOP的只是（采用配置文件的方式）

1、spring依赖库
	* SPRING_HOME/dist/spring.jar
	* SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	* SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	* SPRING_HOME/lib/aspectj/*.jar
2、配置如下
	<aop:config>
		<aop:aspect id="security" ref="securityHandler">
			<aop:pointcut id="allAddMethod" expression="execution(* com.bjsxt.spring.UserManagerImpl.add*(..))"/>
			<aop:before method="checkSecurity" pointcut-ref="allAddMethod"/>
		</aop:aspect>
	</aop:config>	
		
