package com.sist.exam04;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ù��° ����:");
		number1 = sc.nextInt();
		
		System.out.println("�ι�° ����:");
		number2 = sc.nextInt();
		
		result = number1 / number2;
		System.out.println(result);
	}

}
