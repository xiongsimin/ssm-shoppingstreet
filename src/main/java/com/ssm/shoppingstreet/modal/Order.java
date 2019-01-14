package com.ssm.shoppingstreet.modal;

import java.sql.Timestamp;

public class Order {
	private int id;
	private int userId;
	private String number;
	private String orderName;
	private Timestamp time;
	private String status;
	private int addressId;
	private String payMethod;
	private int sumPrice;
	// 以下不是该表数据库字段，只是为了便于接收联表查询结果
	private String consigneeName;
	private String area;
	private String specifiedAddress;
	private int consigneeMobilePhone;
	private String consigneePhone;
	private String consigneeEmail;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int userId, String number, String orderName, Timestamp time, String status, int addressId,
			String payMethod, int sumPrice, String consigneeName, String area, String specifiedAddress,
			int consigneeMobilePhone, String consigneePhone, String consigneeEmail) {
		super();
		this.id = id;
		this.userId = userId;
		this.number = number;
		this.orderName = orderName;
		this.time = time;
		this.status = status;
		this.addressId = addressId;
		this.payMethod = payMethod;
		this.sumPrice = sumPrice;
		this.consigneeName = consigneeName;
		this.area = area;
		this.specifiedAddress = specifiedAddress;
		this.consigneeMobilePhone = consigneeMobilePhone;
		this.consigneePhone = consigneePhone;
		this.consigneeEmail = consigneeEmail;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
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

	public String getConsigneeEmail() {
		return consigneeEmail;
	}

	public void setConsigneeEmail(String consigneeEmail) {
		this.consigneeEmail = consigneeEmail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", number=" + number + ", orderName=" + orderName + ", time="
				+ time + ", status=" + status + ", addressId=" + addressId + ", payMethod=" + payMethod + ", sumPrice="
				+ sumPrice + ", consigneeName=" + consigneeName + ", area=" + area + ", specifiedAddress="
				+ specifiedAddress + ", consigneeMobilePhone=" + consigneeMobilePhone + ", consigneePhone="
				+ consigneePhone + ", consigneeEmail=" + consigneeEmail + "]";
	}

}
