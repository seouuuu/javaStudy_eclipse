package com.sist.exam13;

public interface Movable {
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	final int speed = 100;
	/*
	public void printSpeed() {
		
	}
	*/

}


//1. 메소드를 정의할 때 abstract 생략하여도 되는지 실험 - 가능
//2. int speed 변수추가 - 초기화 할 수 없음
//3. int speed = 100; - 가능
//   final int speed = 100; - 가능
//4. printSpeed() 메소드 추가 - public void printSpeed(); 가능
/*
 public void printSpeed() {
		System.out.println(speed);
	}
	불가능
	*/ 
