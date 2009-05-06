package com.test.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {
	//该属性是依赖注入的属性，该属性可以在配置文件中动态指定该属性值 
	   private String inputPath; 
	//依赖注入该属性值的setter方法 
	    public void setInputPath(String value) 
	{ 
	        inputPath = value; 
	    } 
	/* 
	下载用的Action应该返回一个InputStream实例， 
	该方法对应在result里的inputName属性值为targetFile 
	*/ 
	    public InputStream getTargetFile() throws Exception 
	{ 
	        return ServletActionContext.getServletContext().getResourceAsStream(inputPath); 
	    } 
	//处理用户请求的execute方法，该方法返回success字符串 
	    public String execute() throws Exception 
	{ 
	        return SUCCESS; 
	    } 


}
