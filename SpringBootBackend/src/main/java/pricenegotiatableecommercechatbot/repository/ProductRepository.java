package pricenegotiatableecommercechatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByProductId(Integer productId);

	@Query("SELECT p from Product p, ProductCatalogue pc WHERE pc.productName = :productName and p.productCatalogue.productId = pc.productId")
	List<Product> findByProductCatalogueName(@Param("productName") String productName);

}
