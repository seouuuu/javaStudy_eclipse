package com.sist.exam06;

public class MyArrayTest {

	public static void main(String[] args) {
		
		try {
			MyArray array = new MyArray();
			System.out.println("배열의 평균:" + array.getAverage());
		}catch(NegativeArraySizeException e) {
			System.out.println("예외발생: 배열의 크기는 음수가 될 수 없어요");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생: 배열의 인덱스 범위를 넘었습니다.");
		}catch(NullPointerException e) {
			System.out.println("예외발생: 배열이 생성되지 않았습니다.");
		}catch(ArithmeticException e) {
			System.out.println("예외발생: 배열의 데이터가 하나도 없어요");
		}
	}
}



