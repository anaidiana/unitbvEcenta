package curs.unitbv.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import curs.unitbv.beans.UserBean;
import curs.unitbv.dao.UserDAO;

@Controller
public class UsersController {

	@RequestMapping("/") // map on the root of the page
	public String showHelloPage() {
		return "login";
	}

	@RequestMapping("/showUsers")
	public String showUsers(Model model) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserBean> users = userDAO.getUsers();
		model.addAttribute("users", users);
		return "usersList";
	}
}
