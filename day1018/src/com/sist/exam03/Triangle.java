package com.sist.exam03;

public class Triangle extends TwoDimShape {
	private double width;
	private double height;
	
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

	public Triangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		area = width * height/2;
		return area;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + ", area=" + area + ", x=" + x + ", y=" + y + "]";
	}
	

}
