package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PreviousSearchHistory  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6946695359821007828L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer searchId;
	
	private Integer userId;
	
	private Integer productId;
	
	private BigInteger time;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigInteger getTime() {
		return time;
	}

	public void setTime(BigInteger time) {
		this.time = time;
	}
	
	public PreviousSearchHistory(Integer searchId, Integer userId, Integer productId, BigInteger time) {
		super();
		this.searchId = searchId;
		this.userId = userId;
		this.productId = productId;
		this.time = time;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public PreviousSearchHistory() {
		super();
	}
	
}
