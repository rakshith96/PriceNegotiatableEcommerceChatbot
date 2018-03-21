package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.ProductCatalogue;
import pricenegotiatableecommercechatbot.repository.ProductCatalogueRepository;

@Service
public class ProductCatalogueService {
	
	@Autowired
	private ProductCatalogueRepository productCatalogueRepository;
	
	public Integer addNewProduct(ProductCatalogue productCatalogue) {
		return productCatalogueRepository.save(productCatalogue).getProductId();
	}

	public List<ProductCatalogue> viewAllAvailableProducts() {
		return productCatalogueRepository.findAll();
	}
}
