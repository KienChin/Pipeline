package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

//@Controller
@RestController// same as Controller but w/o ResponseBody?
//@RequestMapping("/users")
public class UserController {
	
	private final static Logger ucLog = Logger.getLogger(UserController.class);
	
	@GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public String test() {
		return "heystephen";
	}
	
	@GetMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
		User login = UserDaoImpl.getDao().getUser(username, password);
		if (login != null) {
			ucLog.info("login successful");
		} else {
			ucLog.info("login failed");
		}
		return login;
	}
}
