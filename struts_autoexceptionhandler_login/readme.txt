1�����ʽ�쳣
	* �ػ��쳣
	* ������Ӧ���쳣��Ϣ
	* �����쳣��Ϣ
	* ת����Ӧ��ҳ�洦���쳣
2������ʽ�쳣���Զ�������쳣��
	* ��struts-config.xml�ļ�������<exeception/>��ǩ
	* ���ֲ���ȫ��exception
	* ע��ֲ�<exception/>��ǩ��Ҫ���õ�<forward/>��ǩ��ǰ�棬���dtd�е�Լ��
	
	<exeception/>��ǩ�е�����˵����
		* key��ָ�쳣��Ϣ��Ӧ�Ĺ��ʻ���Ϣ�ı������keyֵ��Ҫ�ڹ��ʻ���Դ�ļ��ж���
		* type: ���������쳣
		* path: ����һ�������쳣����Ҫת���Ǹ�ҳ�棬���������path��
		         Ĭ������½�ʹ��<action>��ǩ��input���Զ�Ӧ��ҳ��
		* scope������ȡֵrequest��session��Ĭ��Ϊrequest
		* handler���쳣�Ĵ����࣬strutsĬ�ϲ���org.apache.struts.action.ExceptionHandler��
		            ��������Ի����쳣������Լ̳д��าд��Ӧ�ķ���
		            
		�μ���ErrorCodeExceptionHandler.java��AppExceptionHandler.java
				            