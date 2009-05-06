package com.test.action;


import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport
{
	private String username;

	private String password;

	private String repassword;

	private int age;

	private Date birthday;

	private Date graduation;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public Date getGraduation()
	{
		return graduation;
	}

	public void setGraduation(Date graduation)
	{
		this.graduation = graduation;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
//	�Է���abc��ʹ��
	
//	PUBLIC STRING ABC() THROWS EXCEPTION
//	{
//		SYSTEM.OUT.PRINTLN("ABC");
//		RETURN SUCCESS;
//	}
//	//��������ABC���������ݼ�ⷽ������STRUCTS��������ʹ��ABC
//	PUBLIC VOID VALIDATEABC(){
//		SYSTEM.OUT.PRINTLN("VALIDATEABC");
//	}
	
	public String abc() throws Exception
	{
		//System.out.println("abc");
		return SUCCESS;
	}
	
	public void validateAbc(){
		System.out.println("validateAbc");
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void validate()
	{
		System.out.println("validate~~~~~~~~~~~~~~~~~~~");
		
//		this.addFieldError("username","aaaaaaaaaaa");
//		
//		this.getFieldErrors().put("username", "bbbbbbbbbbb");
		
//		if(null == username || username.length() < 6 || username.length() > 10)
//		{
//			this.addFieldError("username","�û���Ϊ�ջ��߳��Ȳ���6-10��Χ�ڣ�");
//		}
//		if(null == password || password.length() < 6 || password.length() > 10)
//		{
//			this.addFieldError("password","����Ϊ�ջ������볤�Ȳ���6-10��Χ�ڣ�");
//		}
//		else if(null == repassword || repassword.length() < 6 || repassword.length() > 10)
//		{
//			this.addFieldError("repassword","ȷ������ Ϊ�ջ������볤�Ȳ���6-10��Χ�ڣ�");
//		}
//		else if(!password.equals(repassword))
//		{
//			this.addFieldError("password","������������ܲ�һ�£�");
//		}
//		if(age < 1 || age > 150)
//		{
//			this.addFieldError("age","����Ӧ�����ʺϵķ�Χ�ڣ�1-150)��");
//			
//		}
//		/*if(null == birthday)
//		{
//			this.addFieldError("birthday","birthday invalid");
//		}
//		if(null == graduation)
//		{
//			this.addFieldError("graduation","graduation invalid");
//		}*/
//		if(null != birthday && null != graduation)
//		{
//			Calendar c1 = Calendar.getInstance();
//			c1.setTime(birthday);
//			
//			Calendar c2 = Calendar.getInstance();
//			c2.setTime(graduation);
//			
//			if(!c1.before(c2))
//			{
//				this.addFieldError("birthday","��������Ӧ�����ڱ�ҵ���ڣ�");
//			}
//		}
		
		
		if(null == username || username.length() < 6 || username.length() > 10)
		{
			List list =new ArrayList();
			list.add(username);
//			this.addActionError("�û���Ϊ�ջ��߳��Ȳ���6-10��Χ�ڣ�");
//			this.addActionError(this.getText("username.invalid",list));
			this.addActionError(this.getText("username.invalid",new String[]{username}));
			
		}
		if(null == password || password.length() < 6 || password.length() > 10)
		{
			this.addActionError("����Ϊ�ջ������볤�Ȳ���6-10��Χ�ڣ�");
		}
		else if(null == repassword || repassword.length() < 6 || repassword.length() > 10)
		{
			this.addActionError("ȷ������ Ϊ�ջ������볤�Ȳ���6-10��Χ�ڣ�");
		}
		else if(!password.equals(repassword))
		{
			this.addActionError("������������ܲ�һ�£�");
		}
		if(age < 1 || age > 150)
		{
			this.addActionError("������Ϣ�����������Ӧ�����ʺϵķ�Χ�ڣ�1-150)��");
			
		}
		/*if(null == birthday)
		{
			this.addFieldError("birthday","birthday invalid");
		}
		if(null == graduation)
		{
			this.addFieldError("graduation","graduation invalid");
		}*/
		if(null != birthday && null != graduation)
		{
			Calendar c1 = Calendar.getInstance();
			c1.setTime(birthday);
			
			Calendar c2 = Calendar.getInstance();
			c2.setTime(graduation);
			
			if(!c1.before(c2))
			{
				this.addActionError("����������Ϣ������󣡳�������Ӧ�����ڱ�ҵ���ڣ�");
			}
		}
		
	}
}
