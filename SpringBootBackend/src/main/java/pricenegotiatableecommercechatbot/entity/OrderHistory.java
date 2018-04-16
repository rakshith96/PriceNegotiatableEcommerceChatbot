package pricenegotiatableecommercechatbot.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class OrderHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7606398774556194502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@NotNull
	private Integer transactionId;

	private Integer userId;

	private String status;

	private String productIds;

	private BigInteger time;
	
	private double finalPrice;
	
	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public BigInteger getTime() {
		return time;
	}

	public void setTime(BigInteger time) {
		this.time = time;
	}

	public OrderHistory(Integer orderId, Integer transactionId, Integer userId, String status, String productIds,
			BigInteger time, double finalPrice) {
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.userId = userId;
		this.status = status;
		this.productIds = productIds;
		this.time = time;
		this.finalPrice = finalPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public OrderHistory() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
