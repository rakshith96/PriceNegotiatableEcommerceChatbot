package pricenegotiatableecommercechatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"pricenegotiatableecommercechatbot.entity"})
@EnableJpaRepositories(basePackages = {"pricenegotiatableecommercechatbot.repository"})
@ComponentScan(basePackages = {"pricenegotiatableecommercechatbot"})
public class DataAccessObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DataAccessObject.class, args);

	}

}
