1、编程式异常
	* 截获异常
	* 创建相应的异常消息
	* 传递异常消息
	* 转向相应的页面处理异常
2、声明式异常（自动处理的异常）
	* 在struts-config.xml文件中配置<exeception/>标签
	* 理解局部和全局exception
	* 注意局部<exception/>标签需要配置到<forward/>标签的前面，详见dtd中的约束
	
	<exeception/>标签中的属性说明：
		* key：指异常信息对应的国际化消息文本，这个key值需要在国际化资源文件中定义
		* type: 处理那种异常
		* path: 定义一但出现异常，需要转向那个页面，如果不定义path，
		         默认情况下将使用<action>标签中input属性对应的页面
		* scope：可以取值request和session，默认为request
		* handler：异常的处理类，struts默认采用org.apache.struts.action.ExceptionHandler，
		            如果做个性化的异常处理可以继承此类覆写相应的方法
		            
		参见：ErrorCodeExceptionHandler.java和AppExceptionHandler.java
				            