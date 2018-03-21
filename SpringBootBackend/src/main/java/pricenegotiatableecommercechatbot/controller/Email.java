package pricenegotiatableecommercechatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.service.EmailService;

@CrossOrigin
@RestController
public class Email {
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/sendMail",  method= RequestMethod.GET)
	public Integer addNewUser() {
		emailService.sendSimpleMessage("rrrakshi10@gmail.com", "Is it working", "Yes it is");//to address followed by subject and text
		return 1;
	}
}
