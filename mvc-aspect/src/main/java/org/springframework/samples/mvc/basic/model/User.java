package org.springframework.samples.mvc.basic.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-4<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class User {
	@NotNull
//	@Length(min = 6, max = 20)
	@Size(min = 1, max = 20)
	private String username;
	
	@NotNull
	@Size(min = 1, max = 20)
//	@Length(min = 6, max = 20)
	private String password;

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

}
