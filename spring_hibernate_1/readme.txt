���ñ��ʽ����

1��getCurrentSession()��openSession()������
	* ����getCurrentSession()������session��󶨵���ǰ�߳��У�������openSession()
	  ������session�򲻻�
	* ����getCurrentSession()������session��commit��rollbackʱ���Զ��رգ�������openSession()
	  ������session�����ֶ��ر�
	  
2��ʹ��getCurrentSession()��Ҫ��hibernate.cfg.xml�ļ��м����������ã�
	* ���ʹ�õ��Ǳ�������jdbc����
	<property name="hibernate.current_session_context_class">thread</property>
	* ���ʹ�õ���ȫ������jta����
	<property name="hibernate.current_session_context_class">jta</property>	    