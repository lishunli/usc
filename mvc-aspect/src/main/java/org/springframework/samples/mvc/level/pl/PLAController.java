package org.springframework.samples.mvc.level.pl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Poincut - it's class level,not package level
 */
@Controller
public class PLAController {

	@RequestMapping("/pla")
	// package level abnormal
	public String initForm() {
		return "welcome";
	}
}
