spring+struts�ļ���(��һ�ּ��ɷ���)
ԭ����Action��ȡ��BeanFactory����Ȼ��ͨ��BeanFactory��ȡҵ���߼�����

1��spring��struts����������
	* ����struts
		--����struts����jstl���
		--�޸�web.xml�ļ�������ActionServlet
		--�ṩstruts-config.xml�ļ�
		--�ṩ���ʻ���Դ�ļ�
	* ����spring
		--����spring���
		--�ṩspring�����ļ� 
		
2����struts��Action�е������´���ȡ��BeanFactory
	BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

3��ͨ��BeanFactoryȡ��ҵ����󣬵���ҵ���߼�����			
		
		 		
