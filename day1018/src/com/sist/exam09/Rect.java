package com.sist.exam09;

public class Rect {
	protected double width;
	protected double height;
	protected double area;
	public Rect(double width,double height) {
		this.width = width;
		this.height = height;
	}
	
	public Rect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final void calcArea() {
		area = width * height;
	}
	public void info() {
		System.out.println("����:"+width+",����:"+height+",����:"+area);
	}
	
}
