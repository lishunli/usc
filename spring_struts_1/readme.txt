spring+struts的集成(第一种集成方案)
原理：在Action中取得BeanFactory对象，然后通过BeanFactory获取业务逻辑对象

1、spring和struts依赖库配置
	* 配置struts
		--拷贝struts类库和jstl类库
		--修改web.xml文件来配置ActionServlet
		--提供struts-config.xml文件
		--提供国际化资源文件
	* 配置spring
		--拷贝spring类库
		--提供spring配置文件 
		
2、在struts的Action中调用如下代码取得BeanFactory
	BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

3、通过BeanFactory取得业务对象，调用业务逻辑方法			
		
		 		
