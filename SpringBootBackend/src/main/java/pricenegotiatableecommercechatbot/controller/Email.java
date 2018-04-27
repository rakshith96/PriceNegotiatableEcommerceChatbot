package pricenegotiatableecommercechatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.service.EmailService;

@CrossOrigin
@RestController
public class Email {
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/sendMail",  method= RequestMethod.GET)
	public Integer sendMail(@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("body") String body) {
		emailService.sendSimpleMessage(email,subject,body);//to address followed by subject and text
		return 1;
	}
}
