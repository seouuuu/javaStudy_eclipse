package com.sist.exam04;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DivideByZeroTest02 {

	public static void main(String[] args) {
		try {
			int number1, number2, result;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("ù��° ����:");
			number1 = sc.nextInt();
			
			System.out.println("�ι�° ����:");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
		}catch(InputMismatchException e) {
			//System.out.println("���ܹ߻�:"+e.getMessage());
			e.printStackTrace();
		}catch(ArithmeticException e) {
			//System.out.println("���ܹ߻�:"+e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("�۾��Ϸ�");
		}
	}

}
