package com.bsms.bsms.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsms.bsms.model.Account;
import com.bsms.bsms.model.Customer;
import com.bsms.bsms.model.RegisterForm;
import com.bsms.bsms.model.Role;
import com.bsms.bsms.service.AccountService;
import com.bsms.bsms.service.CustomerService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/login")
	String loginPage(Model model) {
		return "login_page";
	}

	@GetMapping(value = { "", "/home" })
	String homePage(Model model, Principal principal) {
		model.addAttribute("principal", principal);
		return "home_page";
	}

	@GetMapping("/register")
	String registerPage(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return "register_page";
	}

	@PostMapping("/register")
	String register(Model model, RegisterForm registerForm) {
		Account account = accountService.findAccountByEmail(registerForm.getEmail());

		if (account != null) {
			model.addAttribute("registerForm", registerForm);
			return "register_page";
		}

		Role customerRole = new Role();
		customerRole.setName("ROLE_CUSTOMER");
		List<Role> roles = new ArrayList<>();
		roles.add(customerRole);
		account = new Account();
		account.setEmail(registerForm.getEmail());
		account.setPassword(registerForm.getPassword());
		account.setFirstName(registerForm.getFirstName());
		account.setLastName(registerForm.getLastName());
		account.setAddress(registerForm.getAddress());
		account.setPhone(registerForm.getPhone());
		account.setRoles(roles);
		accountService.addAccount(account);

		Customer customer = new Customer();
		customerService.addCustomer(customer);

		return "redirect:/registerSuccess_page";
	}

	@GetMapping("/access_denied")
	public String accessDeniedPage(Model model, Principal principal) {

		return "access_denied_page";
	}
}