package com.sist.exam10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("ù ��° ����: ");
			number1 = sc.nextInt();
			
			System.out.println("�� ��° ����: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);	
		}catch(DivideByZeroException d) {
			System.out.println("���ܹ߻�:"+d.getMessage());
		}
	}
	
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator == 0) {
			throw new DivideByZeroException("0���� ���� �� �����ϴ�.");
		}
		return numerator/denominator;
	}
}

