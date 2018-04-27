package pricenegotiatableecommercechatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.RegisteredUser;
import pricenegotiatableecommercechatbot.repository.UserRepository;

@Service
public class UserService {
		
	@Autowired
	private UserRepository userRepository;

	public RegisteredUser addNewUser(RegisteredUser user) {
		return userRepository.save(user);
	}

	public RegisteredUser authenticateUser(String username) {
		return userRepository.findByUserName(username);
	}

	public RegisteredUser getUserByUserId(Integer userId) {
		return userRepository.findById(userId);
	}
	
}
