package org.springframework.samples.mvc.basic.service;

import org.springframework.samples.mvc.basic.model.User;

public interface Userervice  {
	void login(User user);
	void logout(User user);
}
