package com.sist.exam03;

//���α׷� ����� �ΰ��� ������ ���޹޾� ������ �� ����� ����ϴ� ���α׷� �ۼ�
public class DivTestException {

	public static void main(String[] args) {
		
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a/b;
			System.out.println("���:"+div);
		}catch(ArithmeticException e ) {
			System.out.println("0���� ���� �� �����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("������ �� �� ���� ���� �����ϼ���");
		}catch(NumberFormatException e) {
			System.out.println("���ڸ� �����ؾ��մϴ�.");
		}
	}
}
