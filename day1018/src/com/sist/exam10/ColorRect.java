package com.sist.exam10;

//final클래스는 상속 할 수 없음
public class ColorRect extends Rect {
	private String color;

	public ColorRect(double width, double height, String color) {
		super(width, height);
		this.color = color;
	}
	
	public void info() {
		System.out.println("가로:"+width+",세로:"+height+",a면적"+area+",색상:"+color);
	}
}
