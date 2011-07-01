package org.springframework.samples.mvc.basic.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.mvc.basic.service.AccessControlListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/reload")
public class ReloadController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Resource(name = "acl.service.accessControlService")
	private AccessControlListService accessControlListService;

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm() {
		log.debug("Invoke getCreateForm()...");
		return "createForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String test() {
		log.debug("----------------------------------------");
		log.debug("Invoke test()...");
		log.debug("Call {} isAccessible...", accessControlListService);
		accessControlListService.isAccessible();
		// System.out.println("Result: " +
		// accessControlListService.isAccessible());
		// System.out.println("Result2: " + accessControlListService);
		return "welcome";
	}

}
