package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return "Username: "+ username + " Password: "+password;
	}
}
