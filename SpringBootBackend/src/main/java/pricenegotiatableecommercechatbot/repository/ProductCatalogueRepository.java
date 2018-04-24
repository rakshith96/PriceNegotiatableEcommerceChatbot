package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.ProductCatalogue;

@Repository
public interface ProductCatalogueRepository extends JpaRepository<ProductCatalogue,Integer>{

	@Query("SELECT p from ProductCatalogue p , CategoryCatalogue c where c.categoryId = p.categoryCatalogue.categoryId and c.categoryName = :categoryName")
	List<ProductCatalogue> findByCategoryName(@Param("categoryName") String categoryName);

}
