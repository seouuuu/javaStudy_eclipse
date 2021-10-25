package com.sist.exam03;

public class ThrowTest {

	public static void main(String[] args) {
		
		//예외상황이 되면 자동으로 예외객체 생성
		//int a = 4/0;
		
		
		//강제로 예외 발생 가능
		throw new ArithmeticException();

	}

}
