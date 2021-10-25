package com.sist.exam09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {                                  //2��
			System.out.println("ù ��° ����: ");
			number1 = sc.nextInt();
			
			System.out.println("�� ��° ����: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
		}catch(InputMismatchException i) {
			System.out.println("������ �Է��ϼ���");
		}catch(ArithmeticException a){
			System.out.println("0���� ���� �� �����ϴ�.");
		}finally {                             //3��
			System.out.println("����");
		}
	}
}

//1. 1) 4  2)InputMismatchException 3)ArithmeticException