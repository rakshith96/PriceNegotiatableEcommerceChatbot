package pricenegotiatableecommercechatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pricenegotiatableecommercechatbot.entity.CategoryCatalogue;
import pricenegotiatableecommercechatbot.service.CategoryCatalogueService;

@CrossOrigin
@RestController
public class CategoryCatalogueController {
	
	@Autowired
	private CategoryCatalogueService categoryCatalogueService;
	
	@RequestMapping(value="/addNewCategory",  method= RequestMethod.POST)
	public Integer addNewUser(@RequestBody CategoryCatalogue categoryCatalogue ) {
		return categoryCatalogueService.addNewCategory(categoryCatalogue);
	}

	@RequestMapping(value="/viewAllAvailableCategory",  method= RequestMethod.GET)
	public List<CategoryCatalogue> viewAllAvailableCategory() {
		return categoryCatalogueService.viewAllAvailableCategory();
	}
	
}
