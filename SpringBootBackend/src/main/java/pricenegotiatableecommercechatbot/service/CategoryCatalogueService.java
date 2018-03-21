package pricenegotiatableecommercechatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pricenegotiatableecommercechatbot.entity.CategoryCatalogue;
import pricenegotiatableecommercechatbot.repository.CategoryCatalogueRepository;

@Service
public class CategoryCatalogueService {
	
	@Autowired
	private CategoryCatalogueRepository categoryCatalogueRepository;
	
	public Integer addNewCategory(CategoryCatalogue categoryCatalogue) {
		return categoryCatalogueRepository.save(categoryCatalogue).getCategoryId();
	}

	public List<CategoryCatalogue> viewAllAvailableCategory() {
		return categoryCatalogueRepository.findAll();
	}

}
