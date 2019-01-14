package com.ssm.shoppingstreet.modal;

public class Hello {
	private Integer id;
	private String name;
	
	public Hello() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hello(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Modal [id=" + id + ", name=" + name + "]";
	}
	
	
}
