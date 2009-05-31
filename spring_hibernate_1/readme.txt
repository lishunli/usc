采用编程式事务

1、getCurrentSession()与openSession()的区别？
	* 采用getCurrentSession()创建的session会绑定到当前线程中，而采用openSession()
	  创建的session则不会
	* 采用getCurrentSession()创建的session在commit或rollback时会自动关闭，而采用openSession()
	  创建的session必须手动关闭
	  
2、使用getCurrentSession()需要在hibernate.cfg.xml文件中加入如下配置：
	* 如果使用的是本地事务（jdbc事务）
	<property name="hibernate.current_session_context_class">thread</property>
	* 如果使用的是全局事务（jta事务）
	<property name="hibernate.current_session_context_class">jta</property>	    