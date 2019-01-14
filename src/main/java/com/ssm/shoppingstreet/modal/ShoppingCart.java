package com.ssm.shoppingstreet.modal;

import java.sql.Timestamp;

public class ShoppingCart {
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Timestamp time;
	private int num;
	private String productName;
	private String description;
	private int price;
	private int bonusPoints;
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(Integer id, Integer userId, Integer productId, Timestamp time, int num) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.time = time;
		this.num = num;
	}
	public ShoppingCart(Integer id, Integer userId, Integer productId, Timestamp time, int num, String productName,
			String description, int price, int bonusPoints) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.time = time;
		this.num = num;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.bonusPoints = bonusPoints;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", userId=" + userId + ", productId=" + productId + ", time=" + time
				+ ", num=" + num + ", productName=" + productName + ", description=" + description + ", price=" + price
				+ ", bonusPoints=" + bonusPoints + "]";
	}
	
}
