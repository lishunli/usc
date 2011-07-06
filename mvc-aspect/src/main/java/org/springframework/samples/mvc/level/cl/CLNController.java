package org.springframework.samples.mvc.level.cl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Poincut - it's class level,not package level
 */
@Controller
public class CLNController {

	@RequestMapping("/cln")
	// class level normal
	public String initForm() {
		return "welcome";
	}
}
