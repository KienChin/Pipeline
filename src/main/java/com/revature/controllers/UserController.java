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
	
	@GetMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User login(HttpServletRequest req, @RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("yes");
		
		HttpSession var = req.getSession(false);
		
		User login = null;
		
		if (var == null) {
			HttpSession session = req.getSession();
			login = UserDaoImpl.getDao().getUser(username,password);
			session.setAttribute("user", login);
		} else {
			System.out.println("we have a session");
			login = (User) req.getSession().getAttribute("user");
		}
		System.out.println(login);
		return login;
	}
}
