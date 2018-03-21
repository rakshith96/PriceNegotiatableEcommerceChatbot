package pricenegotiatableecommercechatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pricenegotiatableecommercechatbot.entity.ProductCatalogue;

@Repository
public interface ProductCatalogueRepository extends JpaRepository<ProductCatalogue,Integer>{

}
