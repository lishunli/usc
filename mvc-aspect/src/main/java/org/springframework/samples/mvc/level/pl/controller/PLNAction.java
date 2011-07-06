package org.springframework.samples.mvc.level.pl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Poincut - it's package level,not class level
 */
@Controller
public class PLNAction {

	@RequestMapping("/pln")
	// package level normal
	public String initForm() {
		return "welcome";
	}
}
