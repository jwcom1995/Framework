package com.test02;

public class Address {
	private String name;
	private String addr;
	private String phone;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "name=" + name + "\t addr=" + addr + "\t phone=" + phone;
	}
		
}
