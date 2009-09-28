package cn.itcast.strutsdemo.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts.upload.FormFile;

public class User implements Serializable {
	private String username;
	private String password;
	private Integer height;	
	private Date birthday;
	private int [] specialities;
	private Gender gender;
	private FormFile photo;
	private String resume;
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int[] getSpecialities() {
		return specialities;
	}
	public void setSpecialities(int[] specialities) {
		this.specialities = specialities;
	}
	//Speciality[] specialities;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
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
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

}
