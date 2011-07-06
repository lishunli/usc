package org.springframework.samples.mvc.level.cl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Poincut - it's package level,not class level
 */
@Controller
public class CLAAction {

	@RequestMapping("/cla")
	// class level abnormal
	public String initForm() {
		return "welcome";
	}
}
