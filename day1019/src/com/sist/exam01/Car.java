package com.sist.exam01;

public class Car implements Movable {
	private String name;
	private String color;
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void speedUp(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount+"��ŭ �ӵ��� �ø��ϴ�.");
	}

	@Override
	public void speedDown(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount+"��ŭ �ӵ��� �����ϴ�.");
	}
	
	public void turnLeft() {
		System.out.println("��ȸ���մϴ�.");
	}
	
	public void turnRight() {
		System.out.println("��ȸ���մϴ�.");
	}
}
