package org.springframework.samples.mvc.ajax.account;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();

	private Validator validator;

	@Autowired
	public AccountController(Validator validator) {
		System.out.println("invoke AccountController()... " + validator.toString());
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		System.out.println("invoke getCreateForm()...");
		model.addAttribute(new Account());
		return "account/createForm";
	}

	@RequestMapping(value = "/availability", method = RequestMethod.GET)
	public @ResponseBody AvailabilityStatus getAvailability(@RequestParam String name) {
		System.out.println("invoke getAvailability()...");
		for (Account a : accounts.values()) {
			if (a.getName().equals(name)) {
				return AvailabilityStatus.notAvailable(name);
			}
		}
		return AvailabilityStatus.available();
	}

	@RequestMapping(value = "/validate/{propertyName}", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> validate(@RequestBody Account account, @PathVariable String propertyName) {
		System.out.println("invoke validate()...");
		System.out.println("account's name:" + account);
		System.out.println("propertyName:" + propertyName);

		Set<ConstraintViolation<Account>> failures = validator.validateProperty(account, propertyName);
		if (!failures.isEmpty()) {
			// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return validationMessages(failures);
		}

		HashMap<String, String> successReturn = new HashMap<String, String>();
		successReturn.put(propertyName, "");
		return successReturn;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> create(@RequestBody Account account) {//, HttpServletResponse response
		System.out.println("invoke create()...");
		Set<ConstraintViolation<Account>> failures = validator.validate(account);
		if (!failures.isEmpty()) {
			// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return validationMessages(failures);
		} else {
			accounts.put(account.assignId(), account);
			return Collections.singletonMap("id", account.getId());
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Account get(@PathVariable Long id) {
		System.out.println("invoke get()...");
		Account account = accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		return account;
	}

	// internal helpers
	private Map<String, String> validationMessages(Set<ConstraintViolation<Account>> failures) {
		System.out.println("invoke validationMessages()...");
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<Account> failure : failures) {
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		System.out.println("failureMessages: " + failureMessages);
		return failureMessages;
	}

}
