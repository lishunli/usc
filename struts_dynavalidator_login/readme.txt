struts validator验证框架

1、配置：
	* 加入国际化配置在struts-config.xml文件中，如：
	  <message-resources parameter="MessageResources" />
	* 提供国际化资源文件
	* 引入validator插件在struts-config.xml文件中，如：
	  <plug-in className="org.apache.struts.validator.ValidatorPlugIn">
    	<set-property
        property="pathnames"
        value="/WEB-INF/validator-rules.xml,/WEB-INF/validation.xml"/>
  	  </plug-in>
  	* 提供validation.xml和validator_rules.xml文件，将此文件拷贝到WEB-INF下

2、validator服务器端验证
	* 配置validation.xml文件

3、validator客户端验证(javascript)
) 	* 配置validation.xml文件
	* 在jsp页面中包含< html:javascript> 
	* 对需要验证的表单定义onsubmit事件,其中事件名称为validate+ActionForm的名称，如：validateLoginForm 