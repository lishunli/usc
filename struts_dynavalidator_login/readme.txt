struts validator��֤���

1�����ã�
	* ������ʻ�������struts-config.xml�ļ��У��磺
	  <message-resources parameter="MessageResources" />
	* �ṩ���ʻ���Դ�ļ�
	* ����validator�����struts-config.xml�ļ��У��磺
	  <plug-in className="org.apache.struts.validator.ValidatorPlugIn">
    	<set-property
        property="pathnames"
        value="/WEB-INF/validator-rules.xml,/WEB-INF/validation.xml"/>
  	  </plug-in>
  	* �ṩvalidation.xml��validator_rules.xml�ļ��������ļ�������WEB-INF��

2��validator����������֤
	* ����validation.xml�ļ�

3��validator�ͻ�����֤(javascript)
) 	* ����validation.xml�ļ�
	* ��jspҳ���а���< html:javascript> 
	* ����Ҫ��֤�ı�����onsubmit�¼�,�����¼�����Ϊvalidate+ActionForm�����ƣ��磺validateLoginForm 