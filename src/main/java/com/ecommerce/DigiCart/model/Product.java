package com.ecommerce.DigiCart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id @GeneratedValue
	private int productId;
	@Column
	private String productName;
	@Column(length=5000)
	private String productDiscription;
	@Column
	private int price;
	@Column
	private String seller;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDiscription="
				+ productDiscription + ", price=" + price + ", seller=" + seller + "]";
	}
	

}
