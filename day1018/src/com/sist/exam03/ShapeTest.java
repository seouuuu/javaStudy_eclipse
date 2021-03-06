package com.sist.exam03;

public class ShapeTest {

	public static void main(String[] args) {
		Shape []arr = new Shape[3]; //객체생성이 아닌 객체를 참조할수 있는 배열선언
		arr[0] = new Ellipse(10,10,20,50);
		arr[1] = new Cube(10,100,100,100,100);
		arr[2] = new Cylinder(10,300,50,100);
		
		/*
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		((TwoDimShape)arr[0]).getArea();
		((ThreeDimShape)arr[1]).getVolume();
		((ThreeDimShape)arr[2]).getVolume();
		
		System.out.println("==================================");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		*/
		
		for(Shape s:arr) {
			if(s instanceof TwoDimShape) {
				((TwoDimShape)s).getArea();
			}else if(s instanceof ThreeDimShape) {
				((ThreeDimShape)s).getVolume();
			}
			System.out.println(s);
		}
	}
}
