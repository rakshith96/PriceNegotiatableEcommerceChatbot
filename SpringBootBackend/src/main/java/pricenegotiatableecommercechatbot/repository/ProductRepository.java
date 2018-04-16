package pricenegotiatableecommercechatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByProductId(Integer productId);

}
