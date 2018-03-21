package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductCatalogue implements Serializable {

	private static final long serialVersionUID = -4525415117367420091L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	private String productName;

	public Integer getProductId() {
		return productId;
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

	public ProductCatalogue(Integer productId, String productName, CategoryCatalogue categoryCatalogue) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryCatalogue = categoryCatalogue;
	}

	public ProductCatalogue() {
		super();
	}

	@ManyToOne(targetEntity = CategoryCatalogue.class)
	@JoinColumn(name = "categoryId", nullable = false)
	private CategoryCatalogue categoryCatalogue;

	public CategoryCatalogue getCategoryCatalogue() {
		return categoryCatalogue;
	}

	public void setCategoryCatalogue(CategoryCatalogue categoryCatalogue) {
		this.categoryCatalogue = categoryCatalogue;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productCatalogue")
	private List<Product> products = new ArrayList<>();
}
