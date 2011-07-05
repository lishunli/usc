package org.springframework.samples.mvc.basic.service.impl;

import org.springframework.samples.mvc.basic.model.User;
import org.springframework.samples.mvc.basic.service.Userervice;
import org.springframework.stereotype.Service;

@Service("mvc.service.userService")
public class UserServiceImpl implements Userervice {
	public void login(User user) {
		// TODO do more things.
	}

	public void logout(User user) {
		// TODO do more things.
	}

}
