package com.sist.exam05;

import java.util.Date;

public class System_CurrentTime {

	public static void main(String[] args) {
		long data = System.currentTimeMillis();
		// ���糯¥�� �ð��� ������ �и��������� �о��
		
		System.out.println(data); 
		//1634715388545
		//1634715423806
		//��������� �뵵�ε� ���
		
		Date today = new Date(data);
		
		//long data2 = 1634715388545;
		//�ڹٴ� ������ ���� ���� ������ int ���
		//int���� ������ �Ѿ ����
		//���������� long�� ǥ���ϱ� ���� ���ڿ� ���̻� l�� ����
		
		long data2 = 1634715388545l; 
		Date date = new Date(data2);
		
		System.out.printf("���ݽð�:%d��%d��%d��",today.getHours(),today.getMinutes(),today.getSeconds());
		System.out.printf(", �����ð�:%d��%d��%d��",date.getHours(),date.getMinutes(),date.getSeconds());
	}
}
