package com.sist.exam04;

import java.util.Scanner;

public class LengthExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data,data2;
		
		System.out.print("��ȣ�� �Է��ϼ���==>");
		data = sc.next();
		
		while(data.length()<8 && data.length()>12) {
			System.out.print("��ȣ�� �Է��ϼ���==>");
			data = sc.next();
		}	
		
		System.out.print("��ȣȮ���� ���� �ѹ��� �Է��ϼ���==>");
		data2 = sc.next();
		
		while(data2.length()<8 && data.length()>12) {
			System.out.print("��ȣȮ���� ���� �ѹ��� �Է��ϼ���==>");
			data2 = sc.next();
		} 
		
		if(data.equals(data2)) {
			System.out.println("��ȣ�� �����մϴ�.");
		}else
			System.out.println("��ȣ�� �������� �ʽ��ϴ�.");
	}
}
