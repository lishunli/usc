1、动态ActionForm
	动态ActionForm是为了避免标准ActionForm膨胀而设计的，使用动态ActionForm可以获得标准
	ActionForm的所有功能
	* 在struts-config.xml文件中定义动态ActionForm,如：
	<form-beans>
		<form-bean name="dynaForm" type="org.apache.struts.action.DynaActionForm">
			<form-property name="username" type="java.lang.String" />
			<form-property name="age" type="java.lang.Integer"/>
		</form-bean>
	</form-beans>
	*在Action中使用动态ActionForm，参见DynaActionFormTestAction.java
		DynaActionForm daf = (DynaActionForm)form;
		String username = (String)daf.get("username");
		Integer age = (Integer)daf.get("age");
		
	动态ActionForm其实是把页面中的html元素的名字和值放到了map中，所以通过get方法可以取出相应的值
	动态ActionForm采用EL表达式的输出方式，${dynabean.map.prop}, 参见：dyna_actionform.jsp
	动态Action的验证，通常使用动态验证框架validator

2、采用struts上传文件
	* 页面的配置，如：
 	<form action="upload.do" method="post" enctype="multipart/form-data">
  		标题：<input type="text" name="title"><br>
  		文件：<input type="file" name="myfile"><br>
  		<input type="submit" value="提交">
  	</form>
 	* ActionForm中使用FormFile来接收上传的文件，参见：UploadActionForm.java
 	* 在Action中调用FormFile取得上传文件数据，采用流输出，即完成上传，参见：UploadTestAction.java
 	* 采用<controller/>标签配置上传参数，如：<controller maxFileSize="10M"/>
 	
3、空字段测试
	* 在表单中没有input输入域，jsp脚本接收到的值为null，el表达式接收到的值为空串
	* 如果表单中的值，没有输入，那么jsp脚本和el表达式接收到的值都为空串
	
4、测试ActionForm类型的自动转换
	* boolean:yes,1,on,true都会转换成True类型，而且忽略大小写，其他情况转换成false
	* Date类型的转换：
		* 如果是java.sql.Date，页面日期的格式必须为yyyy-mm-dd，才可以转换
		* 如果是java.util.Date,默认情况下struts无法转换

	* 自定义转换器的实现步骤
		* 实现converter接口，实现convert方法
		* 将实现的conerter注册，通常情况采用servlet注册
		* 采用servlet注册需要注意标签的配置,<load-on-startup>10</load-on-startup>(也可以采用struts plugin注册)
		
Struts对ActionForm的自动搜集过程：
  * 将页面数据放到map中，其中map中的key为页面中的名称，map中的value为页面中的value值
  * 调用BeanUtils.setProperties方法，将map中的值逐个设置到ActionForm实例上，对于ActionForm中的每个属性
    根据类型调用相应的Converter，然后调用相应的convert方法，将相应的字符串转换成ActionForm中指定的类型
    
可以通过BeanUtils.copyProperties(目标对象，源对象)方法进行对象值的复制。
	

	
 			

	