package com.sist.exam03;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
		int []a = {10,20,30};
		System.out.println(a[3]);
		//배열의 인덱스 범위를 넘는 예외가 발생하지만 
		//ArrayIndexOutOfBoundsException은 RuntimeException의 후손이므로
		//사용자가 예외처리를 하지 않아도 자바가 예외처리를 해 주어 컴파일 가능
		//필요하다면 선택적으로 사용자가 예외처리 가능

	}

}
