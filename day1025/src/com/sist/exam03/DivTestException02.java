package com.sist.exam03;

//���α׷� ����� �ΰ��� ������ ���޹޾� ������ �� ����� ����ϴ� ���α׷� �ۼ�
public class DivTestException02 {

	public static void main(String[] args) {
		
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a/b;
			System.out.println("���:"+div);
		}catch(ArithmeticException e) {
			System.out.println("�и� 0�� �� ���� �����!");
		}catch(Exception e ) {
			System.out.println("������ �� ���� �� ���� �����ؾ� �մϴ�.");
		}finally {
			System.out.println("�۾��Ϸ�");
		}
	}
}
