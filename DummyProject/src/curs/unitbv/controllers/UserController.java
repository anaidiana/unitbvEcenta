package curs.unitbv.controllers;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import curs.unitbv.beans.UserBean;
import curs.unitbv.dao.UserDAO;
import curs.unitbv.interfaces.Human;

@Controller
public class UserController {

	@RequestMapping("/") // map on the root of the page
	public String showHelloPage() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Human userBean = context.getBean("userBean", Human.class);

		context.close();

		System.out.println(userBean.getBehaviour());

		return "userPage";
	}

	@RequestMapping("/showUsers")
	public String showUsers(Model model) {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserBean> users = userDAO.getUsers();
		model.addAttribute("users", users);
		return "usersList";
	}
}
