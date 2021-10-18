package com.sist.exam13;

public class Car implements Movable{

	public void speedUp(int amount) {
		System.out.println("속도를 "+amount+"로 올리세요");
	}
	public void speedDown(int amount) {
		System.out.println("속도를 "+amount+"로 내리세요");
	}
	
	public void printSpeed() {
		System.out.println(speed);
	}
	//5. 반드시 구현하여야 하는 메소드
	boolean flag;
	
	public void TurnLeft(boolean flag) {
		if(flag) {
			System.out.println("왼쪽으로 턴하세요");
		}else 
			System.out.println("직진하세요");
	}
	public void TurnRight(boolean flag) {
		if(flag) {
			System.out.println("오른쪽으로 턴하세요");
		}else 
			System.out.println("직진하세요");
	}
	
	
}
