package com.sist.exam04;

import java.util.Scanner;

public class StringTestValidEmail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String email;
		System.out.print("�̸����� �Է��ϼ���==>");
		email = scanner.next();
		if(email.indexOf("@") != -1) {
			System.out.println("�ùٸ� �̸����Դϴ�.");
		}else {
			System.out.println("�ùٸ� �̸����� �ƴմϴ�.");
		}
	}
}
