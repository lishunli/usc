spring+struts�ļ���(�ڶ��ּ��ɷ���)
ԭ����ҵ���߼�����ͨ��springע�뵽Action�У��Ӷ���������Action���е�ֱ�Ӵ����ѯ

1��spring��struts����������
	* ����struts
		--����struts����jstl���
		--�޸�web.xml�ļ�������ActionServlet
		--�ṩstruts-config.xml�ļ�
		--�ṩ���ʻ���Դ�ļ�
	* ����spring
		--����spring���
		--�ṩspring�����ļ� 
2����ΪAction��Ҫ����ҵ���߼�������������Ҫ��Action���ṩsetter��������spring��ҵ���߼�����ע�����

3����struts-config.xml�ļ�������Action
 	* <action>��ǩ�е�type������Ҫ�޸�Ϊorg.springframework.web.struts.DelegatingActionProxy
 	 DelegatingActionProxy��һ��Action����Ҫ������ȡ��BeanFactory��Ȼ�����<action>�е�path����ֵ
 	 ��IoC������ȡ�ñ��������Ӧ��Action
 	 
4����spring�����ļ�����Ҫ����struts��Action,�磺
	<bean name="/login" class="com.bjsxt.usermgr.actions.LoginAction" scope="prototype">
		<property name="userManager" ref="userManager"/>
	</bean>
	* ����ʹ��name���ԣ�name����ֵ�����struts-config.xml�ļ���<action>��ǩ��path����ֵһ��
	* ����ע��ҵ���߼�����
	* ���齫scope����Ϊprototype,�����ͱ�����struts Action���̰߳�ȫ����
	 	 		
		
