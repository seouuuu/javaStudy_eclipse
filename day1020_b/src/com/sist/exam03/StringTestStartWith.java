package com.sist.exam03;

import java.util.Scanner;

public class StringTestStartWith {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���==>");
		String name = sc.next();
		
		if(name.startsWith("��")) {
			System.out.println("�达�Դϴ�.");
		}else
			System.out.println("�达�� �ƴմϴ�.");
	}
}
