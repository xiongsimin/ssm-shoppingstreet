package com.ssm.shoppingstreet.modal;

public class Address {
	private int id;
	private int userId;
	private String title;
	private String consigneeName;
	private String area;
	private String specifiedAddress;
	private int consigneeMobilePhone;
	private String consigneePhone;
	private String consigneeEmail;
	private int isDefault;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, int userId, String title, String consigneeName, String area, String specifiedAddress,
			int consigneeMobilePhone, String consigneePhone, String consigneeEmail, int isDefault) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.consigneeName = consigneeName;
		this.area = area;
		this.specifiedAddress = specifiedAddress;
		this.consigneeMobilePhone = consigneeMobilePhone;
		this.consigneePhone = consigneePhone;
		this.consigneeEmail = consigneeEmail;
		this.isDefault = isDefault;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSpecifiedAddress() {
		return specifiedAddress;
	}

	public void setSpecifiedAddress(String specifiedAddress) {
		this.specifiedAddress = specifiedAddress;
	}

	public String getConsigneeEmail() {
		return consigneeEmail;
	}

	public void setConsigneeEmail(String consigneeEmail) {
		this.consigneeEmail = consigneeEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getConsigneeMobilePhone() {
		return consigneeMobilePhone;
	}

	public void setConsigneeMobilePhone(int consigneeMobilePhone) {
		this.consigneeMobilePhone = consigneeMobilePhone;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", title=" + title + ", consigneeName=" + consigneeName
				+ ", area=" + area + ", specifiedAddress=" + specifiedAddress + ", consigneeMobilePhone="
				+ consigneeMobilePhone + ", consigneePhone=" + consigneePhone + ", consigneeEmail=" + consigneeEmail
				+ ", isDefault=" + isDefault + "]";
	}

}
