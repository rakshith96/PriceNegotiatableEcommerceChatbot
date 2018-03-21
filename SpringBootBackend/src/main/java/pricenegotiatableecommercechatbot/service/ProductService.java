package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.Product;
import pricenegotiatableecommercechatbot.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Integer addNewProduct(Product product) {
		return productRepository.save(product).getProductId();
	}

	public List<Product> viewAllAvailableProducts() {
		return productRepository.findAll();
	}
}
