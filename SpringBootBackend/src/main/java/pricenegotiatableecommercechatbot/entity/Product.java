package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1441773723984769349L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	
	@ManyToOne(targetEntity = CategoryCatalogue.class)
	@JoinColumn(name="categoryId", nullable = false)
	private CategoryCatalogue categoryCatalogue;

	public Integer getProductId() {
		return productId;
	}

	public Product() {
		super();
	}

	public Product(Integer productId, String productName, CategoryCatalogue categoryCatalogue) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryCatalogue = categoryCatalogue;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CategoryCatalogue getCategoryCatalogue() {
		return categoryCatalogue;
	}

	public void setCategoryCatalogue(CategoryCatalogue categoryCatalogue) {
		this.categoryCatalogue = categoryCatalogue;
	}
}
