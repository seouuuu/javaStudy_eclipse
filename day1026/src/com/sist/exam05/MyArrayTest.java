package com.sist.exam05;

public class MyArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray array = new MyArray();
		System.out.println("�迭�� ���:" + array.getAverage());
	}
}

/*
�� ���α׷�����
1. ArithmeticException 
 - �迭�� ���̰� 0�϶�
2. NegativeArraySizeException
 - �迭�� ���̰� �����϶�
3. ArrayIndexOutOfBoundsException
 - �迭�� �ε��� ������ �Ѵ� �ε����� ���� �Ϸ��� �Ҷ� 
4. NullPointerException
 - �迭������ �����ϱ⸸ �ϰ� �迭�� �������� �ʰ� ����Ϸ� �Ҷ�
*/

