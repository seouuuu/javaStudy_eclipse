package com.sist.exam01;

public interface Movable {
	int speed = 100;
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	
	/*
	public void printSpeed() {
		System.out.println("현재속도: "+speed);
	}
	*/
	//인터페이스에는 body가 구체화된 메소드 포함 불가
}
