package com.sist.exam03;

public class Rectangle extends TwoDimShape {
	
	private double width;
	private double height;
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		area = width * height;
		return 0;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}
	
	

}
