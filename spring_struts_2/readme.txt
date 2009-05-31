spring+struts的集成(第二种集成方案)
原理：将业务逻辑对象通过spring注入到Action中，从而避免了在Action类中的直接代码查询

1、spring和struts依赖库配置
	* 配置struts
		--拷贝struts类库和jstl类库
		--修改web.xml文件来配置ActionServlet
		--提供struts-config.xml文件
		--提供国际化资源文件
	* 配置spring
		--拷贝spring类库
		--提供spring配置文件 
2、因为Action需要调用业务逻辑方法，所以需要在Action中提供setter方法，让spring将业务逻辑对象注入过来

3、在struts-config.xml文件中配置Action
 	* <action>标签中的type属性需要修改为org.springframework.web.struts.DelegatingActionProxy
 	 DelegatingActionProxy是一个Action，主要作用是取得BeanFactory，然后根据<action>中的path属性值
 	 到IoC容器中取得本次请求对应的Action
 	 
4、在spring配置文件中需要定义struts的Action,如：
	<bean name="/login" class="com.bjsxt.usermgr.actions.LoginAction" scope="prototype">
		<property name="userManager" ref="userManager"/>
	</bean>
	* 必须使用name属性，name属性值必须和struts-config.xml文件中<action>标签的path属性值一致
	* 必须注入业务逻辑对象
	* 建议将scope设置为prototype,这样就避免了struts Action的线程安全问题
	 	 		
		
