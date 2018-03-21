package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.Product;
import pricenegotiatableecommercechatbot.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/addNewProduct",  method= RequestMethod.POST)
	public Integer addProduct(@RequestBody Product product) {
		return productService.addNewProduct(product);
	}

	@RequestMapping(value="/viewAllAvailableProducts",  method= RequestMethod.GET)
	public List<Product> viewAllAvailableProducts() {
		return productService.viewAllAvailableProducts();
	}
}
