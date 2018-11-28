package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

@RestController
@RequestMapping("/users") // can test with Postman
public class UserController {
	
	@GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test() {
		return "heystephen";
	}
	
	@PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User login(HttpServletRequest req, @RequestParam("username") String username, @RequestParam("password") String password) {
		HttpSession session = req.getSession();
		User login = null;
		HttpSession var = req.getSession(false);
		if (var == null) {
			login = UserDaoImpl.getDao().getUser(username,password);
			session.setAttribute("user", login);
		} else {
			login = (User) req.getSession().getAttribute("user");
		}
		return login;
	}
}
