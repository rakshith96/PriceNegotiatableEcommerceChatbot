package pricenegotiatableecommercechatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.CategoryCatalogue;

@Repository
public interface CategoryCatalogueRepository extends JpaRepository<CategoryCatalogue,Integer>{

}
