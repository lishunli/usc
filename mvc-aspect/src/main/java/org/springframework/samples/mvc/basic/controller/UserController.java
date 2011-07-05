package org.springframework.samples.mvc.basic.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.mvc.basic.model.User;
import org.springframework.samples.mvc.basic.service.Userervice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "mvc.service.userService")
	private Userervice userervice;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String initForm(Model model) {
		log.debug("Invoke getCreateForm()...");
		model.addAttribute(new User());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model) {
		log.debug("Invoke login()...");
		if (result.hasErrors()) {
			return "login";
		}
		userervice.login(user);
		model.addAttribute(user);
		return "logout";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(User user) {
		log.debug("Invoke logout()...");
		userervice.logout(user);

		return "welcome";
	}

}
