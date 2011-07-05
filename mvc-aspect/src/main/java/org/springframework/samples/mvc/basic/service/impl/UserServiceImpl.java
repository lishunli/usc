package org.springframework.samples.mvc.basic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.mvc.basic.model.User;
import org.springframework.samples.mvc.basic.service.Userervice;
import org.springframework.stereotype.Service;

@Service("mvc.service.userService")
public class UserServiceImpl implements Userervice {
	private Logger log = LoggerFactory.getLogger(getClass());

	public void login(User user) {
		log.info("User {} login,password is {}", user.getUsername(), user.getPassword());
	}

	public void logout(User user) {
		log.info("User {} logout", user.getUsername());
	}

}
