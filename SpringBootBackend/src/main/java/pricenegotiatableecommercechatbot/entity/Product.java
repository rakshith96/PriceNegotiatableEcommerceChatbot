	package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1061590504848395220L;

	@Id
	private Integer productId;
	
	private Integer price;
	
	private String name;
	
	@PrimaryKeyJoinColumn
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private ProductCatalogue productCatalogue;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCatalogue getProductCatalogue() {
		return productCatalogue;
	}

	public void setProductCatalogue(ProductCatalogue productCatalogue) {
		this.productCatalogue = productCatalogue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product(Integer productId, String name, ProductCatalogue productCatalogue, Integer price) {
		super();
		this.productId = productId;
		this.name = name;
		this.productCatalogue = productCatalogue;
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Product() {
		super();
	}
	
}
