package com.sist.cafe;

public class CafeVo {
	private int no;
	private String name;
	private int amount;
	private int price;
	public CafeVo(int no, String name, int amount, int price) {
		super();
		this.no = no;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}
	public CafeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
