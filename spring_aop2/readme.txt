spring��AOP��ֻ�ǣ����������ļ��ķ�ʽ��

1��spring������
	* SPRING_HOME/dist/spring.jar
	* SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	* SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	* SPRING_HOME/lib/aspectj/*.jar
2����������
	<aop:config>
		<aop:aspect id="security" ref="securityHandler">
			<aop:pointcut id="allAddMethod" expression="execution(* com.bjsxt.spring.UserManagerImpl.add*(..))"/>
			<aop:before method="checkSecurity" pointcut-ref="allAddMethod"/>
		</aop:aspect>
	</aop:config>	
		
