package pricenegotiatableecommercechatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.RegisteredUser;
import pricenegotiatableecommercechatbot.service.UserService;

@CrossOrigin
@RestController
public class RegisteredUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@RequestMapping(value="/registerNewUser",  method= RequestMethod.POST)
	public RegisteredUser addNewUser(@RequestBody RegisteredUser user) {
		return userService.addNewUser(user);
	}
	
	@RequestMapping(value="/authenticateUser")
	public RegisteredUser authenticateUser(@RequestParam("username") String username) {
		return userService.authenticateUser(username);
	}
	
}
