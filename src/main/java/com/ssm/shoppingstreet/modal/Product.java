package com.ssm.shoppingstreet.modal;

public class Product {
	private Integer id;
	private String productName;
	private String description;
	private int price;
	private int bonusPoints;
	private int type;
	private String brand;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String productName, String description, int price, int bonusPoints, int type,
			String brand) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.bonusPoints = bonusPoints;
		this.type = type;
		this.brand = brand;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", bonusPoints=" + bonusPoints + ", type=" + type + ", brand=" + brand + "]";
	}
	
}
