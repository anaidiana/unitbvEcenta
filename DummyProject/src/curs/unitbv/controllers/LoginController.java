package curs.unitbv.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import curs.unitbv.beans.UserBean;
import curs.unitbv.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session,
			Model model) {

		UserBean user = userService.loginUser(userId, password);
		if (user == null) {
			model.addAttribute("loginError", "Error occured while logging in. Please try again.");
			return "login";
		}
		session.setAttribute("loggedInUser", user);
		return "redirect:/showUsers";
	}

}
