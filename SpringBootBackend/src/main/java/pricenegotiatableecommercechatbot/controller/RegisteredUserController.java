package pricenegotiatableecommercechatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.RegisteredUser;
import pricenegotiatableecommercechatbot.service.EmailService;
import pricenegotiatableecommercechatbot.service.UserService;

@CrossOrigin
@RestController
public class RegisteredUserController {

	@Autowired
	private UserService userService;
	
	@Autowired EmailService emailService;
	
	@RequestMapping(value="/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@RequestMapping(value="/registerNewUser",  method= RequestMethod.POST)
	public RegisteredUser addNewUser(@RequestBody RegisteredUser user) {
		String text = "Thank you for sighing up for AnHeRa website your username and password are "+user.getUserName()+" , "+user.getPassword()+" ";
		emailService.sendSimpleMessage(user.getEmail(),"Welcome to AnHeRa",text);
		return userService.addNewUser(user);
	}
	
	@RequestMapping(value="/authenticateUser")
	public RegisteredUser authenticateUser(@RequestParam("username") String username) {
		return userService.authenticateUser(username);
	}
	
}
