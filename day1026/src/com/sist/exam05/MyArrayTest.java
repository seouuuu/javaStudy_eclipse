package com.sist.exam05;

public class MyArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray array = new MyArray();
		System.out.println("배열의 평균:" + array.getAverage());
	}
}

/*
이 프로그램에서
1. ArithmeticException 
 - 배열의 길이가 0일때
2. NegativeArraySizeException
 - 배열의 길이가 음수일때
3. ArrayIndexOutOfBoundsException
 - 배열의 인덱스 범위를 넘는 인덱스에 접근 하려고 할때 
4. NullPointerException
 - 배열변수를 선언하기만 하고 배열을 생성하지 않고 사용하려 할때
*/

