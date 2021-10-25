package com.sist.exam09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {                                  //2번
			System.out.println("첫 번째 점수: ");
			number1 = sc.nextInt();
			
			System.out.println("두 번째 정수: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
		}catch(InputMismatchException i) {
			System.out.println("정수를 입력하세요");
		}catch(ArithmeticException a){
			System.out.println("0으로 나눌 수 없습니다.");
		}finally {                             //3번
			System.out.println("종료");
		}
	}
}

//1. 1) 4  2)InputMismatchException 3)ArithmeticException