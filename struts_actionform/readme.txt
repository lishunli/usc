1����̬ActionForm
	��̬ActionForm��Ϊ�˱����׼ActionForm���Ͷ���Ƶģ�ʹ�ö�̬ActionForm���Ի�ñ�׼
	ActionForm�����й���
	* ��struts-config.xml�ļ��ж��嶯̬ActionForm,�磺
	<form-beans>
		<form-bean name="dynaForm" type="org.apache.struts.action.DynaActionForm">
			<form-property name="username" type="java.lang.String" />
			<form-property name="age" type="java.lang.Integer"/>
		</form-bean>
	</form-beans>
	*��Action��ʹ�ö�̬ActionForm���μ�DynaActionFormTestAction.java
		DynaActionForm daf = (DynaActionForm)form;
		String username = (String)daf.get("username");
		Integer age = (Integer)daf.get("age");
		
	��̬ActionForm��ʵ�ǰ�ҳ���е�htmlԪ�ص����ֺ�ֵ�ŵ���map�У�����ͨ��get��������ȡ����Ӧ��ֵ
	��̬ActionForm����EL���ʽ�������ʽ��${dynabean.map.prop}, �μ���dyna_actionform.jsp
	��̬Action����֤��ͨ��ʹ�ö�̬��֤���validator

2������struts�ϴ��ļ�
	* ҳ������ã��磺
 	<form action="upload.do" method="post" enctype="multipart/form-data">
  		���⣺<input type="text" name="title"><br>
  		�ļ���<input type="file" name="myfile"><br>
  		<input type="submit" value="�ύ">
  	</form>
 	* ActionForm��ʹ��FormFile�������ϴ����ļ����μ���UploadActionForm.java
 	* ��Action�е���FormFileȡ���ϴ��ļ����ݣ������������������ϴ����μ���UploadTestAction.java
 	* ����<controller/>��ǩ�����ϴ��������磺<controller maxFileSize="10M"/>
 	
3�����ֶβ���
	* �ڱ���û��input������jsp�ű����յ���ֵΪnull��el���ʽ���յ���ֵΪ�մ�
	* ������е�ֵ��û�����룬��ôjsp�ű���el���ʽ���յ���ֵ��Ϊ�մ�
	
4������ActionForm���͵��Զ�ת��
	* boolean:yes,1,on,true����ת����True���ͣ����Һ��Դ�Сд���������ת����false
	* Date���͵�ת����
		* �����java.sql.Date��ҳ�����ڵĸ�ʽ����Ϊyyyy-mm-dd���ſ���ת��
		* �����java.util.Date,Ĭ�������struts�޷�ת��

	* �Զ���ת������ʵ�ֲ���
		* ʵ��converter�ӿڣ�ʵ��convert����
		* ��ʵ�ֵ�conerterע�ᣬͨ���������servletע��
		* ����servletע����Ҫע���ǩ������,<load-on-startup>10</load-on-startup>(Ҳ���Բ���struts pluginע��)
		
Struts��ActionForm���Զ��Ѽ����̣�
  * ��ҳ�����ݷŵ�map�У�����map�е�keyΪҳ���е����ƣ�map�е�valueΪҳ���е�valueֵ
  * ����BeanUtils.setProperties��������map�е�ֵ������õ�ActionFormʵ���ϣ�����ActionForm�е�ÿ������
    �������͵�����Ӧ��Converter��Ȼ�������Ӧ��convert����������Ӧ���ַ���ת����ActionForm��ָ��������
    
����ͨ��BeanUtils.copyProperties(Ŀ�����Դ����)�������ж���ֵ�ĸ��ơ�
	

	
 			

	