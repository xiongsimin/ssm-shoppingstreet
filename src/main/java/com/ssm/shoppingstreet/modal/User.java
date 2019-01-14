package com.ssm.shoppingstreet.modal;

public class User {
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String sex;
	private String inviterName;
	private String inviterId;
	private int balance;
	private int expense;
	private int returnBonusPoints;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String password, String email, String phone, String sex, String inviterName,
			String inviterId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.inviterName = inviterName;
		this.inviterId = inviterId;
	}
	public User(Integer id, String name, String password, String email, String phone, String sex, String inviterName,
			String inviterId, int balance, int expense, int returnBonusPoints) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.inviterName = inviterName;
		this.inviterId = inviterId;
		this.balance = balance;
		this.expense = expense;
		this.returnBonusPoints = returnBonusPoints;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInviterName() {
		return inviterName;
	}
	public void setInviterName(String inviterName) {
		this.inviterName = inviterName;
	}
	public String getInviterId() {
		return inviterId;
	}
	public void setInviterId(String inviterId) {
		this.inviterId = inviterId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public int getReturnBonusPoints() {
		return returnBonusPoints;
	}
	public void setReturnBonusPoints(int returnBonusPoints) {
		this.returnBonusPoints = returnBonusPoints;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", sex=" + sex + ", inviterName=" + inviterName + ", inviterId=" + inviterId + ", balance=" + balance
				+ ", expense=" + expense + ", returnBonusPoints=" + returnBonusPoints + "]";
	}
	
}
