package com.test.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {
	//������������ע������ԣ������Կ����������ļ��ж�ָ̬��������ֵ 
	   private String inputPath; 
	//����ע�������ֵ��setter���� 
	    public void setInputPath(String value) 
	{ 
	        inputPath = value; 
	    } 
	/* 
	�����õ�ActionӦ�÷���һ��InputStreamʵ���� 
	�÷�����Ӧ��result���inputName����ֵΪtargetFile 
	*/ 
	    public InputStream getTargetFile() throws Exception 
	{ 
	        return ServletActionContext.getServletContext().getResourceAsStream(inputPath); 
	    } 
	//�����û������execute�������÷�������success�ַ��� 
	    public String execute() throws Exception 
	{ 
	        return SUCCESS; 
	    } 


}
