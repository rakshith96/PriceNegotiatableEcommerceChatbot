package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.ProductCatalogue;
import pricenegotiatableecommercechatbot.service.ProductCatalogueService;

@CrossOrigin
@RestController
public class ProductCatalogueController {
	@Autowired
	private ProductCatalogueService productCatalogueService;
	
	@RequestMapping(value="/addNewProductCatalogue",  method= RequestMethod.POST)
	public Integer addNewUser(@RequestBody ProductCatalogue productCatalogue ) {
		return productCatalogueService.addNewProduct(productCatalogue);
	}

	@RequestMapping(value="/viewAllAvailableProductsCatalogue",  method= RequestMethod.GET)
	public List<ProductCatalogue> viewAllAvailableProducts() {
		return productCatalogueService.viewAllAvailableProducts();
	}
	
	@RequestMapping(value="/viewProductCatalogueByCategoryName",  method= RequestMethod.GET)
	public List<ProductCatalogue> viewProductCatalogueByCategoryName(@RequestParam("categoryName") String categoryName) {
//		System.out.println(categoryName);
		return productCatalogueService.viewProductCatalogueByCategoryName(categoryName);
	}
}
