package com.sist.exam06;

public class MyArrayTest {

	public static void main(String[] args) {
		
		try {
			MyArray array = new MyArray();
			System.out.println("�迭�� ���:" + array.getAverage());
		}catch(NegativeArraySizeException e) {
			System.out.println("���ܹ߻�: �迭�� ũ��� ������ �� �� �����");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���ܹ߻�: �迭�� �ε��� ������ �Ѿ����ϴ�.");
		}catch(NullPointerException e) {
			System.out.println("���ܹ߻�: �迭�� �������� �ʾҽ��ϴ�.");
		}catch(ArithmeticException e) {
			System.out.println("���ܹ߻�: �迭�� �����Ͱ� �ϳ��� �����");
		}
	}
}



