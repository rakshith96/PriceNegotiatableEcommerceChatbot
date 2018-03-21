package pricenegotiatableecommercechatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.RegisteredUser;

@Repository
public interface UserRepository extends JpaRepository<RegisteredUser,Integer>{

	RegisteredUser findByUserName(String username);

}
