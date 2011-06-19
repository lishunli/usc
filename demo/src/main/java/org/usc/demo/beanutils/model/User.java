package org.usc.demo.beanutils.model;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private Integer age;
	private Date birthDay;
	private Boolean isActive = Boolean.TRUE;
	private boolean isLogin = false;

	public User() {
	}

	public User(String username, String password, Integer age, Date birthDay) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.birthDay = birthDay;
	}

	public User(String username, String password, Integer age, Date birthDay, Boolean isActive) {
		this(username, password, age, birthDay);
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", birthDay=" + birthDay + ", isActive=" + isActive + "]" + ", isLogin=" + isLogin + "]";
	}

}
